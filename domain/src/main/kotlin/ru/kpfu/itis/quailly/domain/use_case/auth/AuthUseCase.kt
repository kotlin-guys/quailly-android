package ru.kpfu.itis.quailly.domain.use_case.auth

import kotlinx.coroutines.flow.singleOrNull
import ru.kpfu.itis.quailly.domain.model.AuthModel
import ru.kpfu.itis.quailly.domain.repo.AuthRepo
import ru.kpfu.itis.quailly.domain.repo.MerchandisesRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepo: AuthRepo,
    private val merchandisesRepository: MerchandisesRepository
) {

    suspend fun auth(authModel: AuthModel): AuthStatus =
        if (authRepo.auth(authModel)) {
            val merchList = merchandisesRepository.getMerchandisesList().singleOrNull()
            if (merchList?.isEmpty() == true) {
                AuthStatus.EMPTY
            } else {
                AuthStatus.NOT_EMPTY
            }
        } else {
            AuthStatus.UNAUTHORIZED
        }

    enum class AuthStatus {
        NOT_EMPTY,
        EMPTY,
        UNAUTHORIZED
    }
}