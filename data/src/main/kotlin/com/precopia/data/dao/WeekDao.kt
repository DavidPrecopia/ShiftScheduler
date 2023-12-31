package com.precopia.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.precopia.data.constants.DatabaseConstants.WEEK_ID_COLUMN
import com.precopia.data.constants.DatabaseConstants.WEEK_TABLE_NAME
import com.precopia.data.datamodel.WeekDb
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
internal interface WeekDao {
    @Query("SELECT * FROM $WEEK_TABLE_NAME")
    fun getWeeks(): Single<List<WeekDb>>
    
    @Query("SELECT * FROM $WEEK_TABLE_NAME WHERE $WEEK_ID_COLUMN = :id")
    fun getSpecificWeek(id: Int): Single<WeekDb>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWeeks(weeksList: List<WeekDb>): Completable
}