package ru.kpfu.itis.quailly.domain.use_case.auth

import ru.kpfu.itis.quailly.domain.repo.AuthRepo
import javax.inject.Inject

class IsAuthedUseCase @Inject constructor(
    private val authRepo: AuthRepo
) {

    fun execute(): Boolean = authRepo.isAuthed()
}