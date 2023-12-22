package com.precopia.data.repository

import com.precopia.domain.datamodel.Week
import com.precopia.domain.repository.IRepositoryContract
import io.reactivex.rxjava3.core.Single

internal class WeeksRepo: IRepositoryContract.Weeks {
    override fun getWeeks(): Single<List<Week>> {
        TODO("Not yet implemented")
    }
}