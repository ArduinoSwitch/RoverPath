package com.seat.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.seat.data.converter.Converters
import com.seat.data.plateau.PlateauDao
import com.seat.data.plateau.PlateauEntity
import com.seat.data.rover.RoverDao
import com.seat.data.rover.RoverEntity

private const val APP_DB_NAME = "app_database"

@Database(
    entities = [PlateauEntity::class, RoverEntity::class],
    version = 1
)

@TypeConverters(Converters::class)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun plateauDao(): PlateauDao
    abstract fun roverDao(): RoverDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) = Room
            .databaseBuilder(context.applicationContext, AppDatabase::class.java, APP_DB_NAME)
            .build()
    }
}
