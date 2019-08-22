package com.playground.featureshowcase.presentation.list

import com.playground.core_presentation_mvp.base.BaseView
import com.playground.featureshowcase.presentation.list.model.ShowCaseItemModel

interface ShowCaseView : BaseView {

//    @StateStrategyType(SkipStrategy::class)
    fun renderShowCases(items: List<ShowCaseItemModel>)
}