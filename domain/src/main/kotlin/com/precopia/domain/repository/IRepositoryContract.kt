package com.precopia.domain.repository

import com.precopia.domain.datamodel.Week
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IRepositoryContract {
    interface Weeks {
        fun getWeeks(): Single<List<Week>>
        
        fun getSpecificWeek(id: Int): Single<Week>
    }
    
    interface SelectedWeek {
        fun setSelectedWeek(id: Int): Completable
        
        fun getSelectedWeek(): Single<Week>
    }
}