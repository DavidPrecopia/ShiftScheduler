package com.precopia.data.repository

import com.precopia.data.dao.WeekDao
import com.precopia.domain.datamodel.Week
import com.precopia.domain.repository.IRepositoryContract

internal class WeeksRepo(
    private val dao: WeekDao
): IRepositoryContract.Weeks {
    override fun getWeeks() = dao.getWeeks()
        .map {
            mutableListOf<Week>().apply {
                it.forEach { weekDb ->
                    Week(weekDb.id, weekDb.title, weekDb.date)
                }
            }.toList()
        }
    
    override fun getSpecificWeek(id: Int) = dao.getSpecificWeek(id)
        .map { Week(it.id, it.title, it.date) }
}