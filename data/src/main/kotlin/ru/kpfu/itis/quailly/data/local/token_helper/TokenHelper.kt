package ru.kpfu.itis.quailly.data.local.token_helper

interface TokenHelper {

    fun getToken(): String?

    fun saveToken(token: String)
}