package ru.kpfu.itis.quailly.data.network.image.model

import com.google.gson.annotations.SerializedName

data class ImageUploadImgurResponse (

    @SerializedName("data") val data: ImageUploadImgurResult
)

data class ImageUploadImgurResult (

    @SerializedName("id") val id: String,
    @SerializedName("link") val link: String
)