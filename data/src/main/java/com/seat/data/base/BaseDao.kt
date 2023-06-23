package com.seat.data.base

import androidx.room.*

@Dao
interface BaseDao<T: Any> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(obj: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertListSync(obj: List<T>)

    @Update
    suspend fun update(obj: T)

    @Delete
    suspend fun delete(obj: T)
}