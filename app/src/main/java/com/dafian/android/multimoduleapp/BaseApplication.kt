package com.dafian.android.multimoduleapp

import android.app.Application
import com.dafian.android.navigation.injectFeature
import org.koin.android.ext.android.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            androidContext = this@BaseApplication,
            modules = injectFeature()
        )
    }
}