package ru.kpfu.itis.quailly.app.ui.new_item

import android.net.Uri
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.new_item.field_manager.NewItemFieldManager
import ru.kpfu.itis.quailly.app.ui.new_item.model.CategoryResult
import ru.kpfu.itis.quailly.app.ui.utils.resource_provider.ResourceProvider
import ru.kpfu.itis.quailly.domain.model.Category
import ru.kpfu.itis.quailly.domain.use_case.photo.PhotoInteractor
import javax.inject.Inject

class NewItemViewModel @Inject constructor(
    val fieldManager: NewItemFieldManager,

    private val photoInteractor: PhotoInteractor,
    private val resProvider: ResourceProvider
) : BaseViewModel() {

    val reqCodePhoto = 0
    val reqCodeCategory = 1
    val reqCodeDesiredCategories = 2

    val isBtnEnabled = MediatorLiveData<Boolean>().apply {
        addSource(fieldManager.isFormValid) { isFormValid -> this.value = isFormValid }
    }
    val category = MutableLiveData<Category>()

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
            NewItemFragmentDirections.actionNewItemFragmentToDesiredCategoriesFragment(reqCodeDesiredCategories.toString())
        )
    )

    fun onSaveBtnClick() {
        launch {
            isBtnEnabled.value = false
            fieldManager.image.fieldValue.value?.let { uri ->
                photoInteractor.uploadImage(uri.toString())
            }
        }.invokeOnCompletion { isBtnEnabled.value = true }
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