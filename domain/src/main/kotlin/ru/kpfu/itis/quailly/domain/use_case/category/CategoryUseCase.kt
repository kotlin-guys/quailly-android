package ru.kpfu.itis.quailly.domain.use_case.category

import ru.kpfu.itis.quailly.domain.model.Category
import ru.kpfu.itis.quailly.domain.repo.CategoryRepository
import javax.inject.Inject

class CategoryUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    suspend fun getCategories(): List<Category> = categoryRepository.getCategories()
}