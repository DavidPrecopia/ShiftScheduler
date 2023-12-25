package com.precopia.data.buildlogic

import android.app.Application
import com.precopia.data.repository.WeeksRepo
import com.precopia.domain.repository.IRepositoryContract

class WeeksRepoServiceLocator(application: Application) {
    
    private val shiftSchedulerDatabaseServiceLocator: ShiftSchedulerDatabaseServiceLocator =
        ShiftSchedulerDatabaseServiceLocator(application)
    
    private val weeksRepo: IRepositoryContract.Weeks =
        WeeksRepo(
            shiftSchedulerDatabaseServiceLocator.getWeekDao()
        )
    
    fun getWeeksRepo() = weeksRepo
}