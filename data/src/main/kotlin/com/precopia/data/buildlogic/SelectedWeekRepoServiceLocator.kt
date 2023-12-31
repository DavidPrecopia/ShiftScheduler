package com.precopia.data.buildlogic

import android.app.Application
import com.precopia.data.repository.SelectedWeekRepo
import com.precopia.domain.repository.IRepositoryContract

class SelectedWeekRepoServiceLocator(application: Application) {
    
    private val shiftSchedulerDatabaseServiceLocator: ShiftSchedulerDatabaseServiceLocator =
        ShiftSchedulerDatabaseServiceLocator(application)
    
    private val selectedWeekRepo: IRepositoryContract.SelectedWeek =
        SelectedWeekRepo(
            shiftSchedulerDatabaseServiceLocator.getSelectedWeekDao(),
            shiftSchedulerDatabaseServiceLocator.getWeekDao()
        )
    
    fun getSelectedWeekRepo() = selectedWeekRepo
}