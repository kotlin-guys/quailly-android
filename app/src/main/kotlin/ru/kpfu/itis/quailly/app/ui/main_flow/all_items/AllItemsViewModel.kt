package ru.kpfu.itis.quailly.app.ui.main_flow.all_items

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import ru.kpfu.itis.quailly.domain.model.Direction
import ru.kpfu.itis.quailly.domain.model.MerchandiseModel
import ru.kpfu.itis.quailly.domain.model.SwipeModel
import ru.kpfu.itis.quailly.domain.use_case.merchandise.GetMerchandisesForSwipesUseCase
import ru.kpfu.itis.quailly.domain.use_case.swipe.SwipeUseCase
import javax.inject.Inject

class AllItemsViewModel @Inject constructor(
    private val getMerchandisesForSwipesUseCase: GetMerchandisesForSwipesUseCase,
    private val swipeUseCase: SwipeUseCase
) : BaseViewModel() {

    companion object {
        private const val ITEMS_LIMIT = 20
        private const val SWIPE_REQUEST_HOLD = 4
    }

    private var isInitialLoading = true
    private var isItemsEnded = false

    val isOneItem = MutableLiveData(false)
    val noItems = MutableLiveData(true)

    private var items = MutableLiveData<List<MerchandiseModel>>()

    val topItemImage = MutableLiveData<String>()
    val bottomItemImage = MutableLiveData<String>()
    val topItemTitle = MutableLiveData<String>()
    val bottomItemTitle = MutableLiveData<String>()

    private var currentIndex = 0
    private var totalItems = 0

    init {
        fetchItems()
    }

    fun swipe(direction: Direction) = launch {

        swipeUseCase.execute(SwipeModel(direction, getTopCard()!!.id))

        currentIndex += 1

        items.value = items.value?.drop(1)

        updateStream()

        if (totalItems - currentIndex < SWIPE_REQUEST_HOLD && isItemsEnded.not()) {
            fetchItems()
        }
    }

    private fun updateStream() {
        val topCard = getTopCard() ?: return

        topItemImage.value = topCard.pictureUrl
        topItemTitle.value = topCard.name

        val bottomCard = getBottomCard()
        bottomItemImage.value = bottomCard.pictureUrl
        bottomItemTitle.value = bottomCard.name
    }

    private fun fetchItems() = launch {

        val result = getMerchandisesForSwipesUseCase.execute(ITEMS_LIMIT)

        items.value = items.value ?: emptyList<MerchandiseModel>() + result

        totalItems += result.size

        if (result.isEmpty()) isItemsEnded = true else noItems.value = false

        if (result.size == 1) isOneItem.value = true

        if (isInitialLoading) {
            updateStream()
            isInitialLoading = false
        }
    }

    private fun getTopCard(): MerchandiseModel? {
        return when (items.value.isNullOrEmpty()) {
            true -> null
            false -> items.value!![currentIndex % items.value!!.size]
        }
    }

    private fun getBottomCard(): MerchandiseModel = items.value!![(currentIndex + 1) % items.value!!.size]
}
