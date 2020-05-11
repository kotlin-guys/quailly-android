package ru.kpfu.itis.quailly.domain.repo

import ru.kpfu.itis.quailly.domain.model.Category

interface CategoryRepository {

    suspend fun getCategories(): List<Category>
}