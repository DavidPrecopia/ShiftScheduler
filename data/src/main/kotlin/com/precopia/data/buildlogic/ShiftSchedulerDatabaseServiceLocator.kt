package com.precopia.data.buildlogic

import android.app.Application
import com.precopia.data.dao.SelectedWeekDao
import com.precopia.data.dao.WeekDao
import com.precopia.data.database.ShiftSchedulerDatabase

internal class ShiftSchedulerDatabaseServiceLocator(application: Application) {
    private val database: ShiftSchedulerDatabase =
        ShiftSchedulerDatabase.getInstance(application)
    
    private val selectedWeekDao: SelectedWeekDao =
        database.selectedWeekDao()
    
    private val weekDao: WeekDao =
        database.weekDao()
    
    fun getSelectedWeekDao() = selectedWeekDao
    
    fun getWeekDao() = weekDao
}