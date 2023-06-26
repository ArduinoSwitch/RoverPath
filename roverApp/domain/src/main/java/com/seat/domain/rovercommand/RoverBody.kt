package com.seat.domain.rovercommand

import kotlinx.serialization.Serializable

@Serializable
data class RoverBody(
    val topRightCorner: Point,
    val roverPosition: Point,
    val roverDirection: CardinalPoint,
    val movements: String,
)

@Serializable
data class Point(
    val x: Int,
    val y: Int,
)

@Serializable
data class RoverState(
    val position: Point,
    val direction: String,
)

@Serializable
enum class CardinalPoint {
    N, S, E, W, NONE
}
