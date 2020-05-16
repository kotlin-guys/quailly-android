package ru.kpfu.itis.quailly.data.network.model.merchandises

import com.google.gson.annotations.SerializedName

data class NewMerchandiseReqModel (
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("pictureUrl") val pictureUrl: String,
    @SerializedName("categoryId") val categoryId: Int,
    @SerializedName("desiredCategoryIds") val desireCategoriesId: List<Int>
)