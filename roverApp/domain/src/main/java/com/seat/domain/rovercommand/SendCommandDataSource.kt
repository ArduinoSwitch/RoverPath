package com.seat.domain.rovercommand

import com.seat.domain.response.MyResult
import com.seat.domain.response.UiApiError

interface SendCommandDataSource {
    suspend fun sendCommand(body: RoverBody): MyResult<RoverState, UiApiError>
}
