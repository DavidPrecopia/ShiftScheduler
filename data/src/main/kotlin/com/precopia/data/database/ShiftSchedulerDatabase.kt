package com.precopia.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.precopia.data.constants.DatabaseConstants
import com.precopia.data.dao.SelectedWeekDao
import com.precopia.data.dao.WeekDao
import com.precopia.data.datamodel.SelectedWeekDb
import com.precopia.data.datamodel.WeekDb
import java.util.concurrent.Executors

@Database(
    entities = [WeekDb::class, SelectedWeekDb::class],
    version = 1,
    exportSchema = true
)
internal abstract class ShiftSchedulerDatabase: RoomDatabase() {
    
    companion object {
        private var database: ShiftSchedulerDatabase? = null
        
        fun getInstance(application: Application): ShiftSchedulerDatabase =
            database ?: synchronized(this) {
                database ?: buildDatabase(application).also { database = it }
            }
        
        private fun buildDatabase(application: Application): ShiftSchedulerDatabase {
            if (database === null) {
                database = Room.databaseBuilder(
                    application,
                    ShiftSchedulerDatabase::class.java,
                    DatabaseConstants.DATABASE_NAME
                ).addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadExecutor().execute {
                            getInstance(application)
                                .weekDao()
                                .addWeeks(PREPOPULATE_DATA)
                        }
                    }
                }).build()
            }
            return database!!
        }
        
        val PREPOPULATE_DATA = listOf(
            WeekDb(1, "A Week", "072523"),
            WeekDb(2, "B Week", "080123")
        )
    }
    
    abstract fun weekDao(): WeekDao
    
    abstract fun selectedWeekDao(): SelectedWeekDao
}