package com.seat.feature.newcommand

import com.seat.commons.di.FrontDispatchers
import com.seat.commons.navigation.Navigator
import com.seat.commons.navigation.dialog.DialogData
import com.seat.commons.ui.BaseViewModel
import com.seat.domain.response.UiApiError
import com.seat.domain.response.onFailure
import com.seat.domain.response.onSuccess
import com.seat.domain.rovercommand.CardinalPoint
import com.seat.domain.rovercommand.Point
import com.seat.domain.rovercommand.RoverBody
import com.seat.domain.rovercommand.SendCommandUseCase
import com.seat.feature.R
import com.seat.feature.result.PointUi
import com.seat.feature.result.RoverStateUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class NewCommandViewModel(
    dispatchers: FrontDispatchers,
    private val navigator: Navigator,
    private val sendCommandUseCase: SendCommandUseCase,
): BaseViewModel(dispatchers) {
    val topPoint = MutableStateFlow("")
    val rightPoint = MutableStateFlow("")
    val roverPointX = MutableStateFlow("")
    val roverPointY = MutableStateFlow("")
    private val roverDirection = MutableStateFlow(CardinalPoint.NONE)
    val roverMovement = MutableStateFlow("")
    val loading = MutableStateFlow(false)

    private val topRightCorner = combine(topPoint, rightPoint) { top, right ->
        top.isNotEmpty() && right.isNotEmpty()
    }

    private val point = combine(
        roverPointX,
        roverPointY,
        topPoint,
        rightPoint
    ) { x, y, top, right ->
        x.isNotEmpty() && y.isNotEmpty() && x <= right && y <= top
    }

    val isEnabled = combine(
        topRightCorner,
        point,
        roverDirection,
        roverMovement
    ) { topRight, point, direction, movement ->
        topRight && point && direction != CardinalPoint.NONE && isStringValid(movement)
    }

    fun setDirection(direction: CardinalPoint) {
        roverDirection.value = direction
    }

    fun sendCommand() {
        scope.launch {
            loading.value = true
            sendCommandUseCase.invoke(
                RoverBody(
                    topRightCorner = Point(
                        x = rightPoint.value.toInt(),
                        y = topPoint.value.toInt()
                    ),
                    roverPosition = Point(
                        x = roverPointX.value.toInt(),
                        y = roverPointY.value.toInt(),
                    ),
                    roverDirection = roverDirection.value,
                    movements = roverMovement.value
                )
            ).onSuccess {
                navigator.goTo(NewCommandFragmentDirections.navToResult(
                    RoverStateUi(
                        PointUi(
                            it.position.x,
                            it.position.y,
                        ),
                        it.direction
                    )
                ))
            }.onFailure {
                handleUiError(it)
            }
            loading.value = false
        }
    }

    private fun handleUiError(error: UiApiError) = when(error) {
        UiApiError.Generic -> navigator.openDialog(
            DialogData.Informative(
                R.string.dialog_no_connection_title,
                R.string.dialog_no_connection_description,
            )
        )
        UiApiError.NoInternet -> navigator.openDialog(
            DialogData.Informative(
                R.string.dialog_generic_title,
                R.string.dialog_generic_desc,
            )
        )
    }

    private fun isStringValid(input: String): Boolean {
        val regex = Regex("[lmr]+", RegexOption.IGNORE_CASE)
        return input.matches(regex)
    }
}
