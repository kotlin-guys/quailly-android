package ru.kpfu.itis.quailly.domain.model

data class SwipeModel (
    val direction: Direction,
    val merchandiseId: Int
)

enum class Direction {
    LEFT, RIGHT
}