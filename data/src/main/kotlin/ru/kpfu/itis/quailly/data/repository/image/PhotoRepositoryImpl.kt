package ru.kpfu.itis.quailly.data.repository.image

import android.content.Context
import android.net.Uri
import android.os.Environment
import com.example.template.data.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.withContext
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import ru.kpfu.itis.quailly.data.network.image.api.ImageUploadImgurApi
import ru.kpfu.itis.quailly.domain.model.common.ErrorModel
import ru.kpfu.itis.quailly.domain.model.common.Result
import ru.kpfu.itis.quailly.domain.repo.PhotoRepository
import java.net.URI

@ExperimentalCoroutinesApi
@FlowPreview
class PhotoRepositoryImpl @Inject constructor(
    private val context: Context,
    private val imageUploadImgurApi: ImageUploadImgurApi
) : PhotoRepository {

    private companion object {
        const val PATTERN_FORMAT_DATE = "yyyyMMdd_HHmmss"
    }

    private val _currentImageFilePath = ConflatedBroadcastChannel<String>()

    override val currentImageFilePath: Flow<String> = _currentImageFilePath.asFlow()

    override fun generateFile(): File {
        val timeStamp = SimpleDateFormat(PATTERN_FORMAT_DATE, Locale.getDefault()).format(Date())
        val imageFileName = "IMG_${timeStamp}_"
        val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imageFile = File.createTempFile(imageFileName, ".jpg", storageDir)
        _currentImageFilePath.offer(imageFile.absolutePath)
        return imageFile
    }

    override suspend fun uploadPhoto(uri: String): Result<String, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {

                val resolvedUri = Uri.parse(uri)

                val result = if (resolvedUri.scheme.equals("content")) {

                    val bytes =
                        context.contentResolver.openInputStream(resolvedUri)?.readBytes() ?: ByteArray(0)

                    imageUploadImgurApi.uploadImage(
                        bytes.toRequestBody("image/*".toMediaTypeOrNull())
                    )
                } else {

                    val file = File(URI(uri))

                    imageUploadImgurApi.uploadImage(
                        file.asRequestBody("image/*".toMediaTypeOrNull())
                    )
                }

                Result.Success(result.data.link)
            } catch (ex: Exception) {
                Result.Error(ErrorModel())
            }

        }
    }
}