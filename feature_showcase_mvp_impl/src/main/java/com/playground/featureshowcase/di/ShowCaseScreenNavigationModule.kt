package com.playground.featureshowcase.di

import com.playground.corenavigation.IntentKey
import com.playground.corenavigation.IntentResolver
import com.playground.corenavigation.IntentResolverKey
import com.playground.featureshowcase.presentation.list.ShowCaseActivity
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
class ShowCaseScreenNavigationModule {

    @[Provides Singleton IntoMap IntentResolverKey(IntentKey.ShowCase::class)]
    fun provideShowCaseIntentResolver(): IntentResolver<*> {
        return ShowCaseActivity
    }
}