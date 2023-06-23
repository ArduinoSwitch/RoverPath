package com.seat.data.di

import com.seat.data.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory { AppDatabase.getInstance(androidContext()).plateauDao() }
    factory { AppDatabase.getInstance(androidContext()).roverDao() }
}
