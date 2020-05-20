package ru.kpfu.itis.quailly.data.network.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.kpfu.itis.quailly.data.network.model.category.CategoryResponseModel
import ru.kpfu.itis.quailly.data.network.model.merchandises.NewMerchandiseReqModel
import ru.kpfu.itis.quailly.data.network.model.merchandises.MerchandisesResponseModel
import ru.kpfu.itis.quailly.data.network.model.swipe.SwipeReqModel

interface QuaillyAuthedApi {

    @GET("merchandise/categories")
    suspend fun getCategories(): List<CategoryResponseModel>

    @POST("merchandises")
    suspend fun createMerchandise(@Body model: NewMerchandiseReqModel)

    @GET("merchandises")
    suspend fun merchandises(): List<MerchandisesResponseModel>

    @GET("merchandises/next")
    suspend fun getMerchandisesForSwipes(
        @Query("limit") limit: Int
    ): List<MerchandisesResponseModel>

    @POST("swipe")
    suspend fun swipe(@Body model: SwipeReqModel)
}
