package com.playground.featureshowcase.domain

import com.playground.featureshowcase.domain.model.ShowCaseItem
import io.reactivex.Single

interface ShowCaseInteractor {

    fun getInfo(): Single<List<ShowCaseItem>>
}