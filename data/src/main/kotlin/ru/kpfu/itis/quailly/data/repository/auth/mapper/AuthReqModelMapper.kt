package ru.kpfu.itis.quailly.data.repository.auth.mapper

import ru.kpfu.itis.quailly.data.network.model.auth.AuthReqModel
import ru.kpfu.itis.quailly.domain.model.AuthModel
import javax.inject.Inject

class AuthReqModelMapper @Inject constructor(): (AuthModel) -> AuthReqModel {

    override fun invoke(model: AuthModel): AuthReqModel = AuthReqModel(

        email = model.email,
        emailVerified = model.emailVerified,
        name = model.name,
        pictureUrl = model.pictureUrl,
        locale = model.locale,
        familyName = model.familyName,
        givenName = model.givenName
    )
}