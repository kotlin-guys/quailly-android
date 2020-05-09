package ru.kpfu.itis.quailly.domain.model

data class AuthModel (

    val email: String,
    val emailVerified: Boolean?,
    val name: String,
    val pictureUrl: String?,
    val locale: String,
    val familyName: String,
    val givenName: String
)