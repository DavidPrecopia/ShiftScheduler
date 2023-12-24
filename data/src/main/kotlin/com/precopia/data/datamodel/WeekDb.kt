package com.precopia.data.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.precopia.data.constants.DatabaseConstants

@Entity(tableName = DatabaseConstants.WEEK_TABLE_NAME)
internal data class WeekDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseConstants.WEEK_ID_COLUMN)
    val id: Int,
    @ColumnInfo(name = DatabaseConstants.WEEK_TITLE_COLUMN)
    val title: String,
    @ColumnInfo(name = DatabaseConstants.WEEK_DATE_COLUMN)
    val date: String
)