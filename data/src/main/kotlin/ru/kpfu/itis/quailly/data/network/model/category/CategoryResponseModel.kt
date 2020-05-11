package ru.kpfu.itis.quailly.data.network.model.category

import com.google.gson.annotations.SerializedName

data class CategoryResponseModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)