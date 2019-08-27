package com.playground.featureshowcase.presentation.details.di

import com.playground.coreutils.di.general.PerScreen
import dagger.Module
import dagger.Provides

@Module
class ShowCaseDetailsScreenModule(private val showCaseId: Long) {

    @Provides
    @PerScreen
    @ShowCaseIdentifier
    fun provideShowCaseId(): Long = showCaseId
}