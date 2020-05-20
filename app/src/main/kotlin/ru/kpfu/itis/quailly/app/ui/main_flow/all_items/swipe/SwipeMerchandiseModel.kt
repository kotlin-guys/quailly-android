package ru.kpfu.itis.quailly.app.ui.main_flow.all_items.swipe

import ru.kpfu.itis.quailly.domain.model.MerchandiseModel

data class SwipeMerchandiseModel(
    val top: MerchandiseModel,
    val bottom: MerchandiseModel
)