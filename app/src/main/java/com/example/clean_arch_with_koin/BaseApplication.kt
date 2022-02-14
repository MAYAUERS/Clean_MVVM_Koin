package com.example.clean_arch_with_koin

import android.app.Application
import com.example.clean_arch_with_koin.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication :Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(retrofitModule, presentationModule, picassoModule))
        }
    }
}