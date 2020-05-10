package ru.kpfu.itis.quailly.domain.repo

import ru.kpfu.itis.quailly.domain.model.common.Result
import kotlinx.coroutines.flow.Flow
import ru.kpfu.itis.quailly.domain.model.common.ErrorModel
import java.io.File

interface PhotoRepository {

    val currentImageFilePath: Flow<String>

    fun generateFile(): File

    suspend fun uploadPhoto(uri: String): Result<String, ErrorModel>
}