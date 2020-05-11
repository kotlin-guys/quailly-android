package ru.kpfu.itis.quailly.data.network.model.merchandises

import com.google.gson.annotations.SerializedName
import java.util.*

data class MerchandiseResponseModel(
    @SerializedName("authorId")
    val authorId: Int,
    @SerializedName("categoryId")
    val categoryId: Int,
    @SerializedName("created")
    val created: Date,
    @SerializedName("description")
    val description: String,
    @SerializedName("desiredCategoryIds")
    val desiredCategoryIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("pictureUrl")
    val pictureUrl: String
)
