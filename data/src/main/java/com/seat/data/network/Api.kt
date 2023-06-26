package com.seat.data.network

import com.seat.domain.rovercommand.RoverBody
import com.seat.domain.rovercommand.RoverState
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("rover/command")
    suspend fun sendCommand(@Body body: RoverBody): RoverState
}
