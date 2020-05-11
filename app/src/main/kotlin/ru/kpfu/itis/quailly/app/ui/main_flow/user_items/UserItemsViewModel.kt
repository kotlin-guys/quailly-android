package ru.kpfu.itis.quailly.app.ui.main_flow.user_items

import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.map
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.main_flow.user_items.adapter.MerchandiseItemModel
import ru.kpfu.itis.quailly.domain.use_case.merchandise.GetMerchandisesUseCase
import javax.inject.Inject

class UserItemsViewModel @Inject constructor(
    private val getMerchandisesUseCase: GetMerchandisesUseCase
) : BaseViewModel() {

    val merchandisesList = getMerchandisesUseCase().map { models ->
        models.map { MerchandiseItemModel(it.id, it.name, it.pictureUrl) }
    }.asLiveData()

    fun onAddNewItemButtonClick() {
        navigate(
            NavigationCommand.To(
                UserItemsFragmentDirections.actionUserItemsFragmentToNewItemFragment()
            )
        )
    }
}