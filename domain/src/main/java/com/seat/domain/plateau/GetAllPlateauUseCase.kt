package com.seat.domain.plateau

import com.seat.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow

class GetAllPlateauUseCase(
    private val dataSource: PlateauDataSource,
): UseCase<Unit, Flow<List<PlateauModel>>> {
    override fun invoke(params: Unit): Flow<List<PlateauModel>> =
        dataSource.getAllPlateau()
}
