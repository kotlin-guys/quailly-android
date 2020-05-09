package ru.kpfu.itis.quailly.data.network.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.kpfu.itis.quailly.data.network.model.auth.AuthReqModel
import ru.kpfu.itis.quailly.data.network.model.auth.AuthResponseModel

interface QuaillyNotAuthedApi {

    @POST("accounts")
    suspend fun auth(
        @Body reqModel: AuthReqModel
    ): AuthResponseModel
}