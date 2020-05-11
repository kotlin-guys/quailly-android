package ru.kpfu.itis.quailly.data.repository.category.mapper

import ru.kpfu.itis.quailly.data.network.model.category.CategoryResponseModel
import ru.kpfu.itis.quailly.domain.model.Category
import javax.inject.Inject

class CategoryResponseMapper @Inject constructor(): (CategoryResponseModel) -> Category {

    override fun invoke(model: CategoryResponseModel): Category = Category(

        id = model.id,
        name = model.name
    )
}