package ru.kpfu.itis.quailly.app.ui.new_item

import android.net.Uri
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.new_item.field_manager.NewItemFieldManager
import ru.kpfu.itis.quailly.app.ui.new_item.model.CategoryResult
import ru.kpfu.itis.quailly.app.ui.utils.resource_provider.ResourceProvider
import ru.kpfu.itis.quailly.domain.model.Category
import ru.kpfu.itis.quailly.domain.model.NewMerchandiseModel
import ru.kpfu.itis.quailly.domain.model.common.ErrorModel
import ru.kpfu.itis.quailly.domain.model.common.Result
import ru.kpfu.itis.quailly.domain.use_case.merchandise.CreateNewMerchandiseUseCase
import ru.kpfu.itis.quailly.domain.use_case.photo.PhotoInteractor
import java.lang.Exception
import javax.inject.Inject

class NewItemViewModel @Inject constructor(
    val fieldManager: NewItemFieldManager,
    private val photoInteractor: PhotoInteractor,
    private val newMerchandiseUseCase: CreateNewMerchandiseUseCase,
    private val resProvider: ResourceProvider
) : BaseViewModel() {

    val reqCodePhoto = 0
    val reqCodeCategory = 1
    val reqCodeDesiredCategories = 2

    val isBtnEnabled = MediatorLiveData<Boolean>().apply {
        addSource(fieldManager.isFormValid) { isFormValid -> this.value = isFormValid }
    }
    val category = MutableLiveData<Category>()
    private val imageLink = MutableLiveData<String>()

    fun onPhotoClick() = navigate(
        NavigationCommand.To(
            NewItemFragmentDirections.actionNewItemFragmentToChoosePhotoFragment(reqCodePhoto.toString())
        )
    )

    fun onCategoryClick() = navigate(
        NavigationCommand.To(
            NewItemFragmentDirections.actionNewItemFragmentToCategoryFragment(reqCodeCategory.toString())
        )
    )

    fun onDesiredCategoriesClick() = navigate(
        NavigationCommand.To(
            NewItemFragmentDirections.actionNewItemFragmentToDesiredCategoriesFragment(
                reqCodeDesiredCategories.toString()
            )
        )
    )

    fun onSaveBtnClick() {
        launch {
            try {
                isBtnEnabled.value = false

                fieldManager.image.fieldValue.value?.let { uri ->
                    val result = photoInteractor.uploadImage(uri.toString())
                    handleUploadResult(result)
                }

                newMerchandiseUseCase.execute(NewMerchandiseModel(
                    name = fieldManager.name.fieldValue.value ?: "",
                    description = fieldManager.description.fieldValue.value ?: "",
                    pictureUrl = imageLink.value ?: "",
                    categoryId = fieldManager.category.fieldValue.value?.id ?: 0,
                    desireCategoriesId = fieldManager.desiredCategories.fieldValue.value?.map { it.id } ?: emptyList()
                ))

                navigate(
                    NavigationCommand.To(
                        NewItemFragmentDirections.actionNewItemFragmentToMainFlowFragment()
                    )
                )
            } catch (e: Exception) {
                errorMessageLiveData.value = resProvider.getString(R.string.error_common)
            }
        }.invokeOnCompletion { isBtnEnabled.value = true }
    }

    private fun handleUploadResult(result: Result<String, ErrorModel>) {
        when (result) {
            is Result.Success -> imageLink.value = result.data
        }
    }

    override fun onNavigationResult(key: String, value: Any) {
        when (key.toInt()) {
            reqCodePhoto -> {
                value as Uri
                launch {
                    fieldManager.image.fieldValue.value = value
                }
            }
            reqCodeCategory -> {
                value as CategoryResult
                fieldManager.category.fieldValue.value = Category(value.id, value.name)
            }
            reqCodeDesiredCategories -> {
                value as List<CategoryResult>
                fieldManager.desiredCategories.fieldValue.value = value.map { Category(it.id, it.name) }
            }
        }
    }
}