package ru.kpfu.itis.quailly.data.repository.category

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kpfu.itis.quailly.data.network.api.QuaillyAuthedApi
import ru.kpfu.itis.quailly.data.repository.category.mapper.CategoryResponseMapper
import ru.kpfu.itis.quailly.domain.model.Category
import ru.kpfu.itis.quailly.domain.repo.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val quillyAuthedApi: QuaillyAuthedApi,
    private val categoryResponseMapper: CategoryResponseMapper
) : CategoryRepository {

    override suspend fun getCategories(): List<Category> = withContext(Dispatchers.IO) {
        quillyAuthedApi.getCategories().map { categoryResponseMapper.invoke(it) }
    }
}