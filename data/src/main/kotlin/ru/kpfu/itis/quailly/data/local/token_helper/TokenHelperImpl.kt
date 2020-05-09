package ru.kpfu.itis.quailly.data.local.token_helper

import ru.kpfu.itis.quailly.data.local.shared_prefs.SharedPrefsProvider
import javax.inject.Inject

class TokenHelperImpl @Inject constructor(
    private val sharedPrefsProvider: SharedPrefsProvider
): TokenHelper {

    private companion object {
        const val KEY_TOKEN = "auth_token"
    }

    override fun getToken(): String? = sharedPrefsProvider.readString(KEY_TOKEN)

    override fun saveToken(token: String) {
        sharedPrefsProvider.writeString(KEY_TOKEN, token)
    }
}