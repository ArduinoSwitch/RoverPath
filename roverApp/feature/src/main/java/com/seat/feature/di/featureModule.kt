package com.seat.feature.di

import com.seat.feature.newcommand.NewCommandViewModel
import com.seat.feature.result.ResultViewModel
import com.seat.feature.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel {
        SplashViewModel(
            get(),
            get(),
        )
    }

    viewModel {
        NewCommandViewModel(
            dispatchers = get(),
            navigator = get(),
            sendCommandUseCase = get(),
        )
    }

    viewModel {
        ResultViewModel(
            dispatchers = get(),
            navigator = get(),
        )
    }
}
