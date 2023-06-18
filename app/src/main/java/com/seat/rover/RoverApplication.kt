package com.seat.rover

import android.app.Application
import com.seat.commons.di.commonsModule
import com.seat.data.di.dataModule
import com.seat.domain.di.domainModule
import com.seat.feature.di.featureModule
import com.seat.rover.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class RoverApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RoverApplication)
            modules(
                appModule,
                commonsModule,
                domainModule,
                dataModule,
                featureModule
            )
        }
    }
}
