package ru.kpfu.itis.quailly.domain.use_case.swipe

import ru.kpfu.itis.quailly.domain.model.SwipeModel
import ru.kpfu.itis.quailly.domain.repo.MerchandisesRepository
import javax.inject.Inject

class SwipeUseCase @Inject constructor(
    private val merchandisesRepository: MerchandisesRepository
) {

    suspend fun execute(swipeModel: SwipeModel) = merchandisesRepository.swipe(swipeModel)
}
