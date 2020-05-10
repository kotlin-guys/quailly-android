package ru.kpfu.itis.quailly.data.network.image.api

import ru.kpfu.itis.quailly.data.network.image.model.ImageUploadImgurResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ImageUploadImgurApi {

    @POST("upload")
    suspend fun uploadImage(@Body image: RequestBody): ImageUploadImgurResponse
}