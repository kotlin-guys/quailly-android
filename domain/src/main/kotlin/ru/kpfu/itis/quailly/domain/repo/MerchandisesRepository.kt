package ru.kpfu.itis.quailly.domain.repo

import kotlinx.coroutines.flow.Flow
import ru.kpfu.itis.quailly.domain.model.MerchandiseModel

interface MerchandisesRepository {

    fun getMerchandisesList(): Flow<List<MerchandiseModel>>
}
