package ru.kpfu.itis.quailly.data.network.model.auth

import com.google.gson.annotations.SerializedName

data class AuthReqModel (

    @SerializedName("email") val email: String,
    @SerializedName("emailVerified") val emailVerified: Boolean?,
    @SerializedName("name") val name: String,
    @SerializedName("pictureUrl") val pictureUrl: String?,
    @SerializedName("locale") val locale: String,
    @SerializedName("familyName") val familyName: String,
    @SerializedName("givenName") val givenName: String
)