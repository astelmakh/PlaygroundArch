package com.playground.featureshowcase.di

import com.playground.coreutils.di.general.PerFeature
import com.playground.featureshowcase.data.ShowCaseImageProviderImpl
import com.playground.featureshowcase.data.ShowCaseRepositoryImpl
import com.playground.featureshowcase.di.module.ShowCaseFeatureDataModule
import com.playground.featureshowcase.di.module.ShowCaseFeatureDatabaseModule
import com.playground.featureshowcase.domain.ShowCaseInteractor
import com.playground.featureshowcase.domain.ShowCaseInteractorImpl
import com.playground.featureshowcase.domain.data.ShowCaseImageProvider
import com.playground.featureshowcase.domain.data.ShowCaseRepository
import dagger.Binds
import dagger.Module

@Module(
    includes = [ShowCaseFeatureDatabaseModule::class,
        ShowCaseFeatureDataModule::class,
        ShowCaseNavigationModule::class]
)
abstract class ShowCaseFeatureModule {

    @PerFeature
    @Binds
    abstract fun provideShowCaseImageProvider(imageProviderImpl: ShowCaseImageProviderImpl): ShowCaseImageProvider

    @PerFeature
    @Binds
    abstract fun provideShowCaseGateway(gatewayImpl: ShowCaseRepositoryImpl): ShowCaseRepository

    @PerFeature
    @Binds
    abstract fun provideShowCaseInteractor(interactor: ShowCaseInteractorImpl): ShowCaseInteractor
}