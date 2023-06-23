package com.seat.data.plateau

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plateau")
data class PlateauEntity(
    @PrimaryKey(autoGenerate = true) val plateauId: Long,
    val sizeX: Int,
    val sizeY: Int,
)
