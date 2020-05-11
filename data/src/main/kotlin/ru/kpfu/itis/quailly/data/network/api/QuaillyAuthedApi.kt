package ru.kpfu.itis.quailly.data.network.api

import retrofit2.http.GET
import ru.kpfu.itis.quailly.data.network.model.merchandises.MerchandiseResponseModel

interface QuaillyAuthedApi {

    @GET("merchandises")
    suspend fun merchandises(): List<MerchandiseResponseModel>
}
