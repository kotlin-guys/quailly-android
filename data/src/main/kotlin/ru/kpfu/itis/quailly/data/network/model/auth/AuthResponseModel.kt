package ru.kpfu.itis.quailly.data.network.model.auth

import com.google.gson.annotations.SerializedName

data class AuthResponseModel (
    @SerializedName("token") val token: String
)