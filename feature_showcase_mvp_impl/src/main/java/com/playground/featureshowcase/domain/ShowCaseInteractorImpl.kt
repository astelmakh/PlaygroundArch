package com.playground.featureshowcase.domain

import com.playground.featureshowcase.domain.data.ShowCaseRepository
import com.playground.featureshowcase.domain.model.ShowCaseItem
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class ShowCaseInteractorImpl
@Inject constructor(private val repository: ShowCaseRepository) : ShowCaseInteractor {

    override fun getItemInfo(id: Long): Maybe<ShowCaseItem> {
        return repository.getInfo(id)
    }

    override fun getInfo(): Single<List<ShowCaseItem>> {
        return repository.getInfo(true)
            .map { it ->
                it.sortedByDescending { it.createdTime }
                    .dropLast(2)
            }
    }

    override fun refreshInfo(): Single<List<ShowCaseItem>> {
        return repository.getInfo(false)
            .map { it ->
                it.sortedByDescending { it.createdTime }
                    .dropLast(2)
            }
    }
}