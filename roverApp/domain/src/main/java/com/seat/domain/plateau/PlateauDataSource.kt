package com.seat.domain.plateau

import kotlinx.coroutines.flow.Flow

interface PlateauDataSource {
    fun getAllPlateau(): Flow<List<PlateauModel>>
}