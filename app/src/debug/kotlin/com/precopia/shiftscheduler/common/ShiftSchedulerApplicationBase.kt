package com.precopia.shiftscheduler.common

import timber.log.Timber

internal class ShiftSchedulerApplicationBase: ApplicationBase() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
    }
    
    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}