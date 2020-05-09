package ru.kpfu.itis.quailly.domain.use_case.auth

import ru.kpfu.itis.quailly.domain.model.AuthModel
import ru.kpfu.itis.quailly.domain.repo.AuthRepo
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val authRepo: AuthRepo) {

    suspend fun auth(authModel: AuthModel): Boolean = authRepo.auth(authModel)
}