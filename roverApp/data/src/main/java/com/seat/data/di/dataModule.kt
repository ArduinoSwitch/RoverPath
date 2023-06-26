package com.seat.data.di

import com.seat.data.BuildConfig
import com.seat.data.network.ApiProvider
import com.seat.data.network.command.SendCommandDataSourceImpl
import com.seat.data.network.interceptors.NetworkConnectivityInterceptor
import com.seat.domain.rovercommand.SendCommandDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    factory<SendCommandDataSource> { SendCommandDataSourceImpl(get()) }

    single { ApiProvider.provideApi(retrofit = get()) }
    single {
        ApiProvider.provideOkHttpClient(
            loggingInterceptor = get(),
            networkConnectivityInterceptor = get(),
        )
    }
    single { ApiProvider.provideLoggingInterceptor(BuildConfig.DEBUG) }
    single { ApiProvider.provideRetrofit(okHttpClient = get()) }
    single { NetworkConnectivityInterceptor(androidContext()) }
}
