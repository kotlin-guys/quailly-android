package ru.kpfu.itis.quailly.domain.model

import java.util.*

data class MerchandiseModel(
    val authorId: Int,
    val categoryId: Int,
    val created: Date,
    val description: String,
    val desiredCategoryIds: List<Int>,
    val id: Int,
    val name: String,
    val pictureUrl: String
)
