package com.playground.featureshowcase.domain

import com.playground.featureshowcase.domain.model.ShowCaseItem
import io.reactivex.Single

interface ShowCaseGateway {

    fun getInfo(count: Int? = null): Single<List<ShowCaseItem>>
}