package com.maikals.basearchitecture

import android.app.Application
import com.maikals.basearchitecture.di.modules
import org.koin.android.ext.android.startKoin
import org.koin.standalone.KoinComponent

class BaseApplication: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}