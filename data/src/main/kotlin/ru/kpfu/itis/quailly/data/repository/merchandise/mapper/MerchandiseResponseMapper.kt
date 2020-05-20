package ru.kpfu.itis.quailly.data.repository.merchandise.mapper

import ru.kpfu.itis.quailly.data.network.model.merchandises.MerchandisesResponseModel
import ru.kpfu.itis.quailly.domain.model.MerchandiseModel
import javax.inject.Inject

class MerchandiseResponseMapper @Inject constructor() :
        (MerchandisesResponseModel) -> MerchandiseModel {

    override fun invoke(responseModel: MerchandisesResponseModel): MerchandiseModel =
        MerchandiseModel(
            responseModel.authorId,
            responseModel.categoryId,
            responseModel.created,
            responseModel.description,
            responseModel.desiredCategoryIds,
            responseModel.id,
            responseModel.name,
            responseModel.pictureUrl
        )
}
