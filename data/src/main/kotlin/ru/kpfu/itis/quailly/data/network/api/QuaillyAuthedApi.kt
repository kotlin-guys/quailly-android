package ru.kpfu.itis.quailly.data.network.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.kpfu.itis.quailly.data.network.model.category.CategoryResponseModel
import ru.kpfu.itis.quailly.data.network.model.item.ItemReqModel

interface QuaillyAuthedApi {

    @GET("merchandise/categories")
    suspend fun getCategories(): List<CategoryResponseModel>

    @POST("createMerchandise")
    suspend fun createItem(@Body model: ItemReqModel)
}