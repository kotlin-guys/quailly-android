package ru.kpfu.itis.quailly.domain.use_case.merchandise

import ru.kpfu.itis.quailly.domain.repo.MerchandisesRepository
import javax.inject.Inject

class GetMerchandisesUseCase @Inject constructor(
    private val merchandisesRepository: MerchandisesRepository
) {
    operator fun invoke() = merchandisesRepository.getMerchandisesList()
}
