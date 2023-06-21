package com.seat.feature.di

import com.seat.feature.dashboard.OnBoardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel {
        OnBoardingViewModel(get())
    }
}
