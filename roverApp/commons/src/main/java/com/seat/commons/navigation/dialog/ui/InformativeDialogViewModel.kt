package com.seat.commons.navigation.dialog.ui

import com.seat.commons.di.FrontDispatchers
import com.seat.commons.ui.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

open class InformativeDialogViewModel(dispatchers: FrontDispatchers) : BaseViewModel(dispatchers) {
    private val _dismiss = MutableSharedFlow<Unit>()
    val dismiss: Flow<Unit> = _dismiss

    open fun onPositive() { dismiss() }

    private fun dismiss() = scope.launch { _dismiss.emit(Unit) }
}
