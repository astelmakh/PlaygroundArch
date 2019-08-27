package com.playground.featureshowcase.presentation.details.di

import com.playground.coreutils.di.general.PerScreen
import com.playground.featureshowcase.presentation.details.ShowCaseDetailsFragment
import com.playground.featureshowcase.presentation.details.ShowCaseDetailsPresenter
import dagger.Subcomponent

@Subcomponent(modules = [ShowCaseDetailsScreenModule::class])
@PerScreen
interface ShowCaseDetailsScreenComponent {

    fun showCaseDetailsPresenter(): ShowCaseDetailsPresenter

    fun inject(where: ShowCaseDetailsFragment)
}