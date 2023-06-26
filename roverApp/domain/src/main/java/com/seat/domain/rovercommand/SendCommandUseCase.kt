package com.seat.domain.rovercommand

import com.seat.commons.di.BackDispatchers
import com.seat.domain.response.MyResult
import com.seat.domain.response.UiApiError
import com.seat.domain.usecase.UseCaseSuspend
import kotlinx.coroutines.withContext

class SendCommandUseCase(
    private val dataSource: SendCommandDataSource,
    private val backDispatcher: BackDispatchers,
) : UseCaseSuspend<RoverBody, MyResult<RoverState, UiApiError>> {
    override suspend fun invoke(params: RoverBody): MyResult<RoverState, UiApiError> =
        withContext(backDispatcher.io) {
            dataSource.sendCommand(params)
        }
}
