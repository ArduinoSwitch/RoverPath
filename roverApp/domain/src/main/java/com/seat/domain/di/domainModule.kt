package com.seat.domain.di

import com.seat.domain.plateau.GetAllPlateauUseCase
import com.seat.domain.rovercommand.SendCommandUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetAllPlateauUseCase(get()) }
    factory { SendCommandUseCase(get(), get()) }
}
