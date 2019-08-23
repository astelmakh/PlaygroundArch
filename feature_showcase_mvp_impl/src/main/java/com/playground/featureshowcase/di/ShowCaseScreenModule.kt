package com.playground.featureshowcase.di

import android.content.Context
import com.playground.coreutils.di.general.PerScreen
import dagger.Module
import dagger.Provides

@Module
class ShowCaseScreenModule(private val context: Context) {

    @Provides
    @PerScreen
    fun provideContext(): Context {
        return context
    }

}