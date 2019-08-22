package com.playground.feature_purchase_impl.di

import com.playground.corenavigation.IntentKey
import com.playground.corenavigation.IntentResolver
import com.playground.corenavigation.IntentResolverKey
import com.playground.feature_purchase_impl.presentation.PurchaseActivity
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
class PurchaseScreenNavigationModule {

    @[Provides Singleton IntoMap IntentResolverKey(IntentKey.Purchase::class)]
    fun providePurchaseIntentResolver(): IntentResolver<*> {
        return PurchaseActivity
    }
}