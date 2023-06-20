package com.seat.rover.di

import com.seat.rover.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        SplashViewModel(
            get()
        )
    }
}
