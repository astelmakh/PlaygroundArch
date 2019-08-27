package com.playground.featureshowcase.di.module

import com.playground.coreutils.di.general.PerFeature
import com.playground.featureshowcase.cache.ShowCaseCacheImpl
import com.playground.featureshowcase.data.repository.ShowCaseCache
import com.playground.featureshowcase.data.repository.ShowCaseDataStore
import com.playground.featureshowcase.data.source.ShowCaseCacheDataStore
import com.playground.featureshowcase.data.source.ShowCaseCreatorDataStore
import com.playground.featureshowcase.di.qualifier.CacheDataStore
import com.playground.featureshowcase.di.qualifier.CreatorDataStore
import dagger.Binds
import dagger.Module

@Module
abstract class ShowCaseFeatureDataModule {

    @PerFeature
    @Binds
    abstract fun provideShowCaseCache(impl: ShowCaseCacheImpl): ShowCaseCache

    @PerFeature
    @Binds
    @CacheDataStore
    abstract fun provideShowCaseCacheDataStore(impl: ShowCaseCacheDataStore): ShowCaseDataStore

    @PerFeature
    @Binds
    @CreatorDataStore
    abstract fun provideShowCaseCreatorDataStore(impl: ShowCaseCreatorDataStore): ShowCaseDataStore
}