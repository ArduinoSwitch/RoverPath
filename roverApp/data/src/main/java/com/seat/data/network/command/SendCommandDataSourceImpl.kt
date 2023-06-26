package com.seat.data.network.command

import com.seat.data.network.Api
import com.seat.domain.response.*
import com.seat.domain.rovercommand.RoverBody
import com.seat.domain.rovercommand.RoverState
import com.seat.domain.rovercommand.SendCommandDataSource

class SendCommandDataSourceImpl(
    private val api: Api
): SendCommandDataSource {
    override suspend fun sendCommand(body: RoverBody): MyResult<RoverState, UiApiError> =
        ApiErrorHandling.run {
            api.sendCommand(body)
        }.mapError {
            it.toBasicUi()
        }
}
