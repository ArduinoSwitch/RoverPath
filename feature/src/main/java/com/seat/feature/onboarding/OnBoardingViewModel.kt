package com.seat.feature.onboarding

import com.seat.commons.di.FrontDispatchers
import com.seat.commons.navigation.Navigator
import com.seat.commons.ui.BaseViewModel

class OnBoardingViewModel(
    dispatchers: FrontDispatchers,
    private val navigator: Navigator,
) : BaseViewModel(dispatchers) {
    fun navToMain() {
        navigator.goTo(OnBoardingFragmentDirections.navToMain())
    }
}
