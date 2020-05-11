package ru.kpfu.itis.quailly.app.ui.new_item

import android.net.Uri
import androidx.lifecycle.MediatorLiveData
import kotlinx.coroutines.launch
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.new_item.field_manager.NewItemFieldManager
import ru.kpfu.itis.quailly.app.ui.utils.resource_provider.ResourceProvider
import ru.kpfu.itis.quailly.domain.use_case.photo.PhotoInteractor
import javax.inject.Inject

class NewItemViewModel @Inject constructor(
    val fieldManager: NewItemFieldManager,

    private val photoInteractor: PhotoInteractor,
    private val resProvider: ResourceProvider
) : BaseViewModel() {

    val reqCodePhoto = 0

    val isBtnEnabled = MediatorLiveData<Boolean>().apply {
        addSource(fieldManager.isFormValid) { isFormValid -> this.value = isFormValid }
    }

    fun onPhotoClick() = navigate(
        NavigationCommand.To(
            NewItemFragmentDirections.actionNewItemFragmentToChoosePhotoFragment(reqCodePhoto.toString())
        )
    )

    fun onCategoryClick() {

    }

    fun onSaveBtnClick() {
        launch {
            isBtnEnabled.value = false
            fieldManager.image.fieldValue.value?.let { uri ->
                photoInteractor.uploadImage(uri.toString())
            }
        }.invokeOnCompletion { isBtnEnabled.value = true }
    }

    override fun onNavigationResult(value: Any) {
        value as Uri
        launch {
            fieldManager.image.fieldValue.value = value
        }
    }
}