package ru.kpfu.itis.quailly.domain.model

data class NewMerchandiseModel (
    val name: String,
    val description: String,
    val pictureUrl: String,
    val categoryId: Int,
    val desireCategoriesId: List<Int>
)