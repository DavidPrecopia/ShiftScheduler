package com.precopia.data.repository

import com.precopia.data.dao.SelectedWeekDao
import com.precopia.data.dao.WeekDao
import com.precopia.domain.datamodel.Week
import com.precopia.domain.repository.IRepositoryContract

internal class SelectedWeekRepo(
    private val dao: SelectedWeekDao,
    private val weekDao: WeekDao
): IRepositoryContract.SelectedWeek {
    override fun setSelectedWeek(id: Int) = dao.setSelectedWeek(id)
    
    override fun getSelectedWeek() = dao.getSelectedWeek()
        .flatMap { weekDao.getSpecificWeek(it.weekId) }
        .map { Week(it.id, it.title, it.date) }
}