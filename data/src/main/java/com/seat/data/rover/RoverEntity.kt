package com.seat.data.rover

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity (tableName = "rover")
data class RoverEntity(
    @PrimaryKey(autoGenerate = true) val roverId: Long,
    val direction: String,
    @Embedded val command: Command
)

data class Command(
    val movement: List<CardinalPoint>,
    val timeStamp: Date,
)

enum class CardinalPoint {
    N, S, E, W
}
