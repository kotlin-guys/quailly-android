package ru.kpfu.itis.quailly.data.repository.merchandise

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.kpfu.itis.quailly.data.network.api.QuaillyAuthedApi
import ru.kpfu.itis.quailly.data.network.model.merchandises.NewMerchandiseReqModel
import ru.kpfu.itis.quailly.data.network.model.swipe.SwipeReqModel
import ru.kpfu.itis.quailly.data.repository.merchandise.mapper.MerchandiseResponseMapper
import ru.kpfu.itis.quailly.domain.model.MerchandiseModel
import ru.kpfu.itis.quailly.domain.model.NewMerchandiseModel
import ru.kpfu.itis.quailly.domain.model.SwipeModel
import ru.kpfu.itis.quailly.domain.repo.MerchandisesRepository
import javax.inject.Inject

class MerchandisesRepositoryImpl @Inject constructor(
    private val api: QuaillyAuthedApi,
    private val merchandiseResponseMapper: MerchandiseResponseMapper
) : MerchandisesRepository {

    override suspend fun createNewMerchandise(merchandiseModel: NewMerchandiseModel) = withContext(Dispatchers.IO) {
        api.createMerchandise(
            NewMerchandiseReqModel(
                name = merchandiseModel.name,
                description = merchandiseModel.description,
                pictureUrl = merchandiseModel.pictureUrl,
                categoryId = merchandiseModel.categoryId,
                desireCategoriesId = merchandiseModel.desireCategoriesId
            )
        )
    }

    override fun getMerchandisesList(): Flow<List<MerchandiseModel>> =
        flow {
            emit(api.merchandises())
        }.map { it.map(merchandiseResponseMapper) }

    override suspend fun getMerchandisesListForSwipe(limit: Int): List<MerchandiseModel> = withContext(Dispatchers.IO) {
        api.getMerchandisesForSwipes(limit).map { merchandiseResponseMapper.invoke(it) }
    }

    override suspend fun swipe(swipeModel: SwipeModel) = withContext(Dispatchers.IO) {
        api.swipe(SwipeReqModel(swipeModel.direction.name, swipeModel.merchandiseId))
    }
}
