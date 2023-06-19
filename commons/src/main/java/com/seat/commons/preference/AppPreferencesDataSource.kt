package com.seat.commons.preference

interface AppPreferencesDataSource {
    suspend fun getOnBoardStatus(): Boolean
    suspend fun updateOnBoardStatus()
}
