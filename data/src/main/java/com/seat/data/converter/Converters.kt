package com.seat.data.converter

import androidx.room.TypeConverter
import com.seat.data.rover.CardinalPoint
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

object Converters {
    @TypeConverter
    fun fromString(value: String): List<CardinalPoint> {
        return Json.decodeFromString(value)
    }

    @TypeConverter
    fun toString(value: List<CardinalPoint>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun fromTimestamp(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): Long {
        return date.time
    }
}
