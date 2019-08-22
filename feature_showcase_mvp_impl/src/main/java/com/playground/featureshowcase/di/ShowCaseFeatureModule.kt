package com.playground.featureshowcase.di

import com.playground.coreutils.di.general.PerFeature
import com.playground.featureshowcase.data.ShowCaseImageProviderImpl
import com.playground.featureshowcase.domain.ShowCaseGateway
import com.playground.featureshowcase.domain.ShowCaseInteractor
import com.playground.featureshowcase.domain.ShowCaseInteractorImpl
import com.playground.featureshowcase.domain.data.ShowCaseImageProvider
import com.playground.featureshowcase.domain.gateway.ShowCaseGatewayImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ShowCaseFeatureModule {

    @PerFeature
    @Binds
    abstract fun provideShowCaseImageProvider(imageProviderImpl: ShowCaseImageProviderImpl): ShowCaseImageProvider

    @PerFeature
    @Binds
    abstract fun provideShowCaseGateway(gatewayImpl: ShowCaseGatewayImpl): ShowCaseGateway

    @PerFeature
    @Binds
    abstract fun provideShowCaseInteractor(interactor: ShowCaseInteractorImpl): ShowCaseInteractor
}