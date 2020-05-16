package ru.kpfu.itis.quailly.domain.use_case.merchandise

import ru.kpfu.itis.quailly.domain.model.NewMerchandiseModel
import ru.kpfu.itis.quailly.domain.repo.MerchandisesRepository
import javax.inject.Inject

class CreateNewMerchandiseUseCase @Inject constructor(
    private val merchandisesRepository: MerchandisesRepository
) {

    suspend fun execute(newMerchandiseModel: NewMerchandiseModel) =
        merchandisesRepository.createNewMerchandise(newMerchandiseModel)
}