package com.seat.commons.di

import com.seat.commons.navigation.Navigator
import com.seat.commons.navigation.dialog.ui.InformativeDialogViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.binds
import org.koin.dsl.module

private const val APP_PREFERENCES_ACCESSOR = "APP_PREFERENCES"

val commonsModule = module {

    single { Navigator() }
    viewModel { InformativeDialogViewModel(
        dispatchers = get(),
    ) }

    // I don't know why koin are not able to resolve named with AppDispatchers
    // Don't work
    /*
    single(named(DiConstants.Dispatchers.UI)) { Dispatchers.Main.immediate }
    single(named(DiConstants.Dispatchers.CPU)) { Dispatchers.Default }
    single(named(DiConstants.Dispatchers.IO)) { Dispatchers.IO }
    single {
        AppDispatchers(
            get(named(DiConstants.Dispatchers.UI)),
            get(named(DiConstants.Dispatchers.CPU)),
            get(named(DiConstants.Dispatchers.IO)),
        )
    }.binds(arrayOf(FrontDispatchers::class, DomainDispatcher::class, BackDispatchers::class))*/

    // Work
    single {
        AppDispatchers(
            Dispatchers.Main.immediate,
            Dispatchers.Default,
            Dispatchers.IO,
        )
    }.binds(arrayOf(FrontDispatchers::class, DomainDispatcher::class, BackDispatchers::class))
}
