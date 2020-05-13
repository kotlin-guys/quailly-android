package ru.kpfu.itis.quailly.app.ui.new_item.desired_categories

import com.davidecirillo.multichoicerecyclerview.MultiChoiceAdapter
import kotlinx.coroutines.launch
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.adapter.DesiredCategoriesAdapter
import ru.kpfu.itis.quailly.app.ui.new_item.model.CategoryResult
import ru.kpfu.itis.quailly.domain.model.Category
import ru.kpfu.itis.quailly.domain.use_case.category.CategoryUseCase
import javax.inject.Inject

class DesiredCategoriesViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) : BaseViewModel() {

    val adapter = DesiredCategoriesAdapter().apply { setSingleClickMode(true) }
    val categories = mutableListOf<Category>()
    val selectedSet = mutableSetOf<Category>()
    var reqCode: String = ""

    init {
        subsribeToAdapter()
        fetchCategories()
    }

    private fun subsribeToAdapter() {
        adapter.setMultiChoiceSelectionListener(object: MultiChoiceAdapter.Listener {

            override fun OnItemSelected(selectedPosition: Int, itemSelectedCount: Int, allItemCount: Int) {
                selectedSet.add(categories[selectedPosition])
            }

            override fun OnItemDeselected(deselectedPosition: Int, itemSelectedCount: Int, allItemCount: Int) {
                selectedSet.remove(categories[deselectedPosition])
            }

            override fun OnDeselectAll(itemSelectedCount: Int, allItemCount: Int) {
            }

            override fun OnSelectAll(itemSelectedCount: Int, allItemCount: Int) {
            }
        })
    }

    private fun fetchCategories() {
        launch {
            val categories = categoryUseCase.getCategories()
            this@DesiredCategoriesViewModel.categories.clear()
            this@DesiredCategoriesViewModel.categories.addAll(categories)
            adapter.setCategories(categories)
        }
    }

    fun onSaveClick() = navigate(
        NavigationCommand.BackWithResult(
            reqCode = reqCode,
            result = selectedSet.map { CategoryResult(it.id, it.name) }.toList()
        )
    )
}