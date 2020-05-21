package ru.kpfu.itis.quailly.domain.repo

import ru.kpfu.itis.quailly.domain.model.AuthModel

interface AuthRepo {

    suspend fun auth(authModel: AuthModel): Boolean

    fun isAuthed(): Boolean
}