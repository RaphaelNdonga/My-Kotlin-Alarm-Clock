package com.example.android.mykotlinalarmclock

import android.app.Application
import timber.log.Timber

class MyKotlinAlarmClockApplication :Application(){
    override fun onCreate() {
        Timber.plant(Timber.DebugTree())
        super.onCreate()
    }
}