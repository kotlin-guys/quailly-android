package ru.kpfu.itis.quailly.app.ui.new_item.category

import kotlinx.coroutines.launch
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.new_item.category.adapter.CategoryAdapter
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.adapter.DesiredCategoriesAdapter
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.adapter.ItemClickListener
import ru.kpfu.itis.quailly.app.ui.new_item.model.CategoryResult
import ru.kpfu.itis.quailly.domain.model.Category
import ru.kpfu.itis.quailly.domain.use_case.category.CategoryUseCase
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) : BaseViewModel(), ItemClickListener<Category> {

    val adapter = CategoryAdapter(this)
    var reqCode: String = ""

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        launch {
            val categories = categoryUseCase.getCategories()
            adapter.submitList(categories)
        }
    }

    override fun omItemClick(item: Category) = navigate(
        NavigationCommand.BackWithResult(
            reqCode = reqCode,
            result = CategoryResult(item.id, item.name)
        )
    )
}