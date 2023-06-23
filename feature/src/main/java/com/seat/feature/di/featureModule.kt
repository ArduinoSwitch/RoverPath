package com.seat.feature.di

import com.seat.feature.onboarding.OnBoardingViewModel
import com.seat.feature.main.MainViewModel
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
        OnBoardingViewModel(
            dispatchers = get(),
            navigator = get(),
        )
    }

    viewModel {
        MainViewModel(
            dispatchers = get(),
            navigator = get(),
        )
    }
}
