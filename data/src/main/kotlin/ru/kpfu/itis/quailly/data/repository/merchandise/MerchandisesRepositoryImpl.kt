package ru.kpfu.itis.quailly.data.repository.merchandise

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import ru.kpfu.itis.quailly.data.network.api.QuaillyAuthedApi
import ru.kpfu.itis.quailly.data.repository.merchandise.mapper.MerchandiseResponseMapper
import ru.kpfu.itis.quailly.domain.model.MerchandiseModel
import ru.kpfu.itis.quailly.domain.repo.MerchandisesRepository
import javax.inject.Inject

class MerchandisesRepositoryImpl @Inject constructor(
    private val api: QuaillyAuthedApi,
    private val merchandiseResponseMapper: MerchandiseResponseMapper
) : MerchandisesRepository {

    override fun getMerchandisesList(): Flow<List<MerchandiseModel>> =
        flow {
            emit(api.merchandises())
        }.map { it.map(merchandiseResponseMapper) }
}
