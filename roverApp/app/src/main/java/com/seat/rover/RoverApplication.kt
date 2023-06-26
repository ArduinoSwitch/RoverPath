package com.seat.rover

import android.app.Application
import com.seat.commons.di.commonsModule
import com.seat.data.di.dataModule
import com.seat.domain.di.domainModule
import com.seat.feature.di.featureModule
import com.seat.rover.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class RoverApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        setupLogger()
        setupDi()
    }

    private fun setupDi() {
        startKoin {
            androidContext(this@RoverApplication)
            commonsModule.single { applicationScope }
            modules(
                appModule,
                commonsModule,
                domainModule,
                dataModule,
                featureModule
            )
        }
    }

    private fun setupLogger() {
        if (BuildConfig.DEBUG) Timber.plant(LineNumberDebugTree())
    }
}

private class LineNumberDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String {
        return "(${element.fileName}:${element.lineNumber})#${element.methodName}"
    }
}
