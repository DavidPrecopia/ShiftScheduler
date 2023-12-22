package com.precopia.data.repository

import com.precopia.domain.datamodel.Week
import com.precopia.domain.repository.IRepositoryContract
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

internal class SelectedWeekRepo: IRepositoryContract.SelectedWeek {
    override fun setSelectedWeek(id: Int): Completable {
        TODO("Not yet implemented")
    }
    
    override fun getSelectedWeek(): Single<Week> {
        TODO("Not yet implemented")
    }
}