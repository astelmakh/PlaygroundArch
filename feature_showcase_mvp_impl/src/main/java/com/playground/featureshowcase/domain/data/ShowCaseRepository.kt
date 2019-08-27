package com.playground.featureshowcase.domain.data

import com.playground.featureshowcase.domain.model.ShowCaseItem
import io.reactivex.Maybe
import io.reactivex.Single

interface ShowCaseRepository {

    fun getInfo(id: Long): Maybe<ShowCaseItem>
    fun getInfo(isUseCache: Boolean = false, count: Int? = null): Single<List<ShowCaseItem>>
}