package ru.kpfu.itis.quailly.domain.use_case.photo

import ru.kpfu.itis.quailly.domain.model.common.ErrorModel
import ru.kpfu.itis.quailly.domain.model.common.Result
import ru.kpfu.itis.quailly.domain.repo.PhotoRepository
import java.io.File
import javax.inject.Inject

class PhotoInteractor @Inject constructor(
    private val photoRepository: PhotoRepository
) {

    fun generateImage(): File = photoRepository.generateFile()

    suspend fun uploadImage(uri: String): Result<String, ErrorModel> = photoRepository.uploadPhoto(uri)
}