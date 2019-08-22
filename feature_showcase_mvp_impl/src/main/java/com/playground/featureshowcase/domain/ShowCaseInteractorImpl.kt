package com.playground.featureshowcase.domain

import com.playground.featureshowcase.domain.model.ShowCaseItem
import io.reactivex.Single
import javax.inject.Inject

class ShowCaseInteractorImpl
@Inject constructor(private val gateway: ShowCaseGateway) : ShowCaseInteractor {

    override fun getInfo(): Single<List<ShowCaseItem>> {
        return gateway.getInfo()
            .map { it ->
                it.sortedByDescending { it.createdTime }
                    .dropLast(2)
            }
    }
}