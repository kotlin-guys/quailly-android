package ru.kpfu.itis.quailly.domain.repo

import kotlinx.coroutines.flow.Flow
import ru.kpfu.itis.quailly.domain.model.MerchandiseModel
import ru.kpfu.itis.quailly.domain.model.NewMerchandiseModel

interface MerchandisesRepository {

    suspend fun createNewMerchandise(merchandiseModel: NewMerchandiseModel)

    fun getMerchandisesList(): Flow<List<MerchandiseModel>>
}
