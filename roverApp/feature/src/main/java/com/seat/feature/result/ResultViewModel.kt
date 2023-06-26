package com.seat.feature.result

import com.seat.commons.di.FrontDispatchers
import com.seat.commons.navigation.Navigator
import com.seat.commons.ui.BaseViewModel

class ResultViewModel(
    dispatchers: FrontDispatchers,
    private val navigator: Navigator,
): BaseViewModel(dispatchers) {

    fun navigateBack() {
        navigator.back()
    }
}