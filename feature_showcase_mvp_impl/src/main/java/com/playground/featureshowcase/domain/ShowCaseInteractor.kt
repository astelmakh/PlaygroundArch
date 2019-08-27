package com.playground.featureshowcase.domain

import com.playground.featureshowcase.domain.model.ShowCaseItem
import io.reactivex.Maybe
import io.reactivex.Single

interface ShowCaseInteractor {

    fun getItemInfo(id: Long): Maybe<ShowCaseItem>

    fun getInfo(): Single<List<ShowCaseItem>>

    fun refreshInfo(): Single<List<ShowCaseItem>>
}