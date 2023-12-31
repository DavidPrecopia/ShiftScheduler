package com.precopia.data.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.precopia.data.constants.DatabaseConstants
import com.precopia.data.dao.SelectedWeekDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
internal class SelectedWeekDaoTest {
    
    private lateinit var database: ShiftSchedulerDatabase
    private lateinit var dao: SelectedWeekDao
    
    @Before
    fun before() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShiftSchedulerDatabase::class.java,
        ).build()
        
        dao = database.selectedWeekDao()
        
        dao.addInitialSelectedWeek(
            ShiftSchedulerDatabase.PREPOPULATE_DATA_SELECTED_WEEK
        ).test().assertComplete()
    }
    
    @After
    @Throws(IOException::class)
    fun after() {
        database.close()
    }
    
    
    @Test
    @Throws(Exception::class)
    fun setAndGetSelectedWeek() {
        val selectedWeekId = 11111
        
        dao.setSelectedWeek(selectedWeekId)
            .test()
            .assertComplete()
        
        dao.getSelectedWeek()
            .test()
            .assertValue {
                it.id == DatabaseConstants.SELECTED_WEEK_ID_COLUMN_VALUE &&
                it.weekId == selectedWeekId
            }
    }
}