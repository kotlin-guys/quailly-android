package ru.kpfu.itis.quailly.app.ui.auth.start_screen.mapper

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import ru.kpfu.itis.quailly.domain.model.AuthModel
import javax.inject.Inject

class AuthModelMapper @Inject constructor(): (GoogleSignInAccount) -> AuthModel {

    override fun invoke(model: GoogleSignInAccount): AuthModel = AuthModel(

        email = model.email!!,
        emailVerified = true,
        name = model.displayName!!,
        pictureUrl = model.photoUrl.toString(),
        locale = "ru",
        familyName = model.familyName!!,
        givenName = model.givenName!!
    )
}