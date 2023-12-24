package com.precopia.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.precopia.data.constants.DatabaseConstants.SELECTED_WEEK_ID_COLUMN
import com.precopia.data.constants.DatabaseConstants.SELECTED_WEEK_ID_COLUMN_VALUE
import com.precopia.data.constants.DatabaseConstants.SELECTED_WEEK_TABLE_NAME
import com.precopia.data.constants.DatabaseConstants.SELECTED_WEEK_WEEK_ID_COLUMN
import com.precopia.data.datamodel.SelectedWeekDb
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
internal interface SelectedWeekDao {
    @Query("UPDATE $SELECTED_WEEK_TABLE_NAME SET $SELECTED_WEEK_WEEK_ID_COLUMN = :id WHERE $SELECTED_WEEK_ID_COLUMN = $SELECTED_WEEK_ID_COLUMN_VALUE")
    fun setSelectedWeek(id: Int): Completable
    
    @Query("SELECT * FROM $SELECTED_WEEK_TABLE_NAME WHERE $SELECTED_WEEK_ID_COLUMN = $SELECTED_WEEK_ID_COLUMN_VALUE")
    fun getSelectedWeek(): Single<SelectedWeekDb>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addInitialSelectedWeek(selectedWeekDb: SelectedWeekDb): Completable
}