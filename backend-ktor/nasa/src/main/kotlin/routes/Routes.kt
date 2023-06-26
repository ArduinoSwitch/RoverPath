package routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import models.RoverBody
import models.moveRover

fun Route.roverRouting() {
    route("/rover"){
        post("/command") {
            val roverBody = call.receive<RoverBody>()
            val roverState = moveRover(roverBody.topRightCorner, roverBody.roverPosition, roverBody.roverDirection, roverBody.movements)
            call.respond(HttpStatusCode.OK, roverState)
        }
    }
}