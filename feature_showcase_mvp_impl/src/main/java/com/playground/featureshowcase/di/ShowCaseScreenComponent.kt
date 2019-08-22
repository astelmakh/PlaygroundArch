package com.playground.featureshowcase.di

import com.playground.coreutils.di.general.PerScreen
import com.playground.featureshowcase.presentation.list.ShowCaseActivity
import com.playground.featureshowcase.presentation.list.ShowCasePresenter
import dagger.Subcomponent

@Subcomponent(modules = [ShowCaseScreenModule::class])
@PerScreen
interface ShowCaseScreenComponent {

    fun showCaseScreenPresenter(): ShowCasePresenter

    fun inject(where: ShowCaseActivity)
}