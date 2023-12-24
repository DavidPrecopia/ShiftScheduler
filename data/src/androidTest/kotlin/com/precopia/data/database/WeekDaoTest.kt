package com.precopia.data.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.precopia.data.dao.WeekDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
internal class WeekDaoTest {
    private lateinit var database: ShiftSchedulerDatabase
    private lateinit var dao: WeekDao
    
    @Before
    fun before() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShiftSchedulerDatabase::class.java,
        ).build()
        
        dao = database.weekDao()
        
        dao.addWeeks(
            ShiftSchedulerDatabase.PREPOPULATE_DATA_WEEKS
        ).test().assertComplete()
    }
    
    @After
    @Throws(IOException::class)
    fun after() {
        database.close()
    }
    
    
    @Test
    @Throws(Exception::class)
    fun getWeeks() {
        dao.getWeeks()
            .test()
            .assertValue {
                it[0].title == ShiftSchedulerDatabase.PREPOPULATE_DATA_WEEKS[0].title &&
                it[0].date == ShiftSchedulerDatabase.PREPOPULATE_DATA_WEEKS[0].date &&
                it[1].title == ShiftSchedulerDatabase.PREPOPULATE_DATA_WEEKS[1].title &&
                it[1].date == ShiftSchedulerDatabase.PREPOPULATE_DATA_WEEKS[1].date
            }
    }
    
    @Test
    @Throws(Exception::class)
    fun getSpecificWeek() {
        dao.getSpecificWeek(ShiftSchedulerDatabase.PREPOPULATE_DATA_WEEKS[0].id)
            .test()
            .assertValue {
                it.id == ShiftSchedulerDatabase.PREPOPULATE_DATA_WEEKS[0].id
            }
    }
}