package com.playground.featureshowcase.presentation.list.di

import com.playground.coreutils.di.general.PerScreen
import com.playground.featureshowcase.presentation.list.ShowCaseListFragment
import com.playground.featureshowcase.presentation.list.ShowCaseListPresenter
import dagger.Subcomponent

@Subcomponent(modules = [ShowCaseListScreenModule::class])
@PerScreen
interface ShowCaseListScreenComponent {

    fun showCaseListPresenter(): ShowCaseListPresenter

    fun inject(where: ShowCaseListFragment)
}