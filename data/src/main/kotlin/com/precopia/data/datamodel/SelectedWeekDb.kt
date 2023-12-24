package com.precopia.data.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.precopia.data.constants.DatabaseConstants.SELECTED_WEEK_ID_COLUMN
import com.precopia.data.constants.DatabaseConstants.SELECTED_WEEK_ID_COLUMN_VALUE
import com.precopia.data.constants.DatabaseConstants.SELECTED_WEEK_TABLE_NAME
import com.precopia.data.constants.DatabaseConstants.SELECTED_WEEK_WEEK_ID_COLUMN

@Entity(tableName = SELECTED_WEEK_TABLE_NAME)
data class SelectedWeekDb(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = SELECTED_WEEK_ID_COLUMN,
        defaultValue = SELECTED_WEEK_ID_COLUMN_VALUE.toString()
    )
    val id: Int,
    @ColumnInfo(name = SELECTED_WEEK_WEEK_ID_COLUMN)
    val weekId: Int
)
