package ru.kpfu.itis.quailly.data.network.api

import retrofit2.http.GET
import ru.kpfu.itis.quailly.data.network.model.category.CategoryResponseModel

interface QuaillyAuthedApi {

    @GET("merchandise/categories")
    suspend fun getCategories(): List<CategoryResponseModel>
}