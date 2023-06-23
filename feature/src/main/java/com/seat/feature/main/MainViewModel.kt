package com.seat.feature.main

import com.seat.commons.di.FrontDispatchers
import com.seat.commons.navigation.Navigator
import com.seat.commons.ui.BaseViewModel

class MainViewModel(
    dispatchers: FrontDispatchers,
    private val navigator: Navigator
) : BaseViewModel(dispatchers) {
}
