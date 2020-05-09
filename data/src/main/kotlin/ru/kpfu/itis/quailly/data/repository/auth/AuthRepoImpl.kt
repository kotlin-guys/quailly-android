package ru.kpfu.itis.quailly.data.repository.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kpfu.itis.quailly.data.local.token_helper.TokenHelper
import ru.kpfu.itis.quailly.data.network.api.QuaillyNotAuthedApi
import ru.kpfu.itis.quailly.data.repository.auth.mapper.AuthReqModelMapper
import ru.kpfu.itis.quailly.domain.model.AuthModel
import ru.kpfu.itis.quailly.domain.repo.AuthRepo
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(
    private val quaillyNotAuthedApi: QuaillyNotAuthedApi,
    private val tokenHelper: TokenHelper,
    private val authReqModelMapper: AuthReqModelMapper
): AuthRepo {

    override suspend fun auth(authModel: AuthModel): Boolean {

        return try {

            withContext(Dispatchers.IO) {
                val result = quaillyNotAuthedApi.auth(authReqModelMapper(authModel))

                tokenHelper.saveToken(result.token)

                true
            }
        } catch (ex: Exception) {
            false
        }
    }
}