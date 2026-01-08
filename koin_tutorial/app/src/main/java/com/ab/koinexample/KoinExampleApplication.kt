package com.ab.koinexample

import android.app.Application
import com.ab.koinexample.data.dataModule
import com.ab.koinexample.domain.domainModule
import com.ab.koinexample.presentation.sessionModule
import com.ab.koinexample.presentation.uiModule
import com.ab.koinexample.presentation.userModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinExampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinExampleApplication)
            modules(
                dataModule,
                domainModule,
                uiModule,
                sessionModule,
                userModule
            )
        }
    }
}