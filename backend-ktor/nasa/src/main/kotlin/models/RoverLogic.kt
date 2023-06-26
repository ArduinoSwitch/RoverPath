package models

fun moveRover(topRightCorner: Point, roverPosition: Point, roverDirection: String, movements: String): RoverState {
    var currentDirection = roverDirection
    var currentPosition = roverPosition

    for (movement in movements) {
        when (movement) {
            'L' -> currentDirection = rotateLeft(currentDirection)
            'R' -> currentDirection = rotateRight(currentDirection)
            'M' -> currentPosition = move(currentPosition, currentDirection, topRightCorner)
        }
    }

    return RoverState(currentPosition, currentDirection)
}

fun rotateLeft(direction: String): String {
    return when (direction) {
        "N" -> "W"
        "W" -> "S"
        "S" -> "E"
        "E" -> "N"
        else -> direction
    }
}

fun rotateRight(direction: String): String {
    return when (direction) {
        "N" -> "E"
        "E" -> "S"
        "S" -> "W"
        "W" -> "N"
        else -> direction
    }
}

fun move(currentPosition: Point, direction: String, topRightCorner: Point): Point {
    val newPosition = when (direction) {
        "N" -> Point(currentPosition.x, currentPosition.y + 1)
        "E" -> Point(currentPosition.x + 1, currentPosition.y)
        "S" -> Point(currentPosition.x, currentPosition.y - 1)
        "W" -> Point(currentPosition.x - 1, currentPosition.y)
        else -> currentPosition
    }

    // Check if the new position is within the bounds of the top-right corner
    return if (newPosition.x in 0..topRightCorner.x && newPosition.y in 0..topRightCorner.y)
        newPosition
    else
        currentPosition // If outside the bounds, return the current position
}
