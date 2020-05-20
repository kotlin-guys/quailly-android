package ru.kpfu.itis.quailly.domain.use_case.merchandise

import ru.kpfu.itis.quailly.domain.repo.MerchandisesRepository
import javax.inject.Inject

class GetMerchandisesForSwipesUseCase @Inject constructor(
    private val merchandisesRepository: MerchandisesRepository
) {

    suspend fun execute(limit: Int) = merchandisesRepository.getMerchandisesListForSwipe(limit)
}
