package com.seat.feature.splash

import com.seat.commons.di.FrontDispatchers
import com.seat.commons.navigation.Navigator
import com.seat.commons.ui.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    dispatcher: FrontDispatchers,
    private val navigator: Navigator,
): BaseViewModel(dispatcher) {
    val animation = MutableStateFlow(true)

    init {
        scope.launch {
            delay(2000)
            animation.value = false
        }
    }

    fun navToDashboard() {
        navigator.goTo(SplashFragmentDirections.navToOnBoarding())
    }
}
