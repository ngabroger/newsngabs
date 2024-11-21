package com.ngabroger.newsngabs

import android.app.Application
import com.ngabroger.newsngabs.core.modules.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                newsModule
            )
        }
    }
}