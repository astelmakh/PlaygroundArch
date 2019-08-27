package com.playground.featureshowcase.presentation.list.di

import android.content.Context
import com.playground.coreutils.di.general.PerScreen
import dagger.Module
import dagger.Provides

@Module
class ShowCaseListScreenModule(private val context: Context) {

    @Provides
    @PerScreen
    fun provideContext(): Context {
        return context
    }

}