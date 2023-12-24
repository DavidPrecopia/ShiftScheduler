package com.precopia.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.precopia.data.constants.DatabaseConstants
import com.precopia.data.dao.SelectedWeekDao
import com.precopia.data.dao.WeekDao
import com.precopia.data.datamodel.SelectedWeekDb
import com.precopia.data.datamodel.WeekDb

@Database(
    entities = [WeekDb::class, SelectedWeekDb::class],
    version = 1,
    exportSchema = true
)
internal abstract class ShiftSchedulerDatabase: RoomDatabase() {
    
    companion object {
        private var database: ShiftSchedulerDatabase? = null
        
        fun getInstance(application: Application): ShiftSchedulerDatabase {
            if (database === null) {
                database = Room.databaseBuilder(
                    application,
                    ShiftSchedulerDatabase::class.java,
                    DatabaseConstants.DATABASE_NAME
                ).build()
            }
            return database!!
        }
    }
    
    abstract fun weekDao(): WeekDao
    
    abstract fun selectedWeekDao(): SelectedWeekDao
}