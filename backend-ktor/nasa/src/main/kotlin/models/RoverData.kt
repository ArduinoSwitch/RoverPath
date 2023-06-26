package models

import kotlinx.serialization.Serializable

@Serializable
data class RoverBody(
    val topRightCorner: Point,
    val roverPosition: Point,
    val roverDirection: String,
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
