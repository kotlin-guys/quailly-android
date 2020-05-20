package ru.kpfu.itis.quailly.domain.repo

import kotlinx.coroutines.flow.Flow
import ru.kpfu.itis.quailly.domain.model.MerchandiseModel
import ru.kpfu.itis.quailly.domain.model.NewMerchandiseModel
import ru.kpfu.itis.quailly.domain.model.SwipeModel

interface MerchandisesRepository {

    suspend fun createNewMerchandise(merchandiseModel: NewMerchandiseModel)

    fun getMerchandisesList(): Flow<List<MerchandiseModel>>

    suspend fun getMerchandisesListForSwipe(limit: Int): List<MerchandiseModel>

    suspend fun swipe(swipeModel: SwipeModel)
}
