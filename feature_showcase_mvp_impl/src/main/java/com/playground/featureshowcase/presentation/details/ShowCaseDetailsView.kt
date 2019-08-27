package com.playground.featureshowcase.presentation.details

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.playground.core_presentation_mvp.base.BaseMvpView
import com.playground.featureshowcase.presentation.model.ShowCaseItemModel

interface ShowCaseDetailsView : BaseMvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun render(model: ShowCaseItemModel)
}