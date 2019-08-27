package com.playground.feature_purchase_impl.di

import com.playground.coreutils.di.general.PerFeature
import com.playground.feature_purchase_api.starter.PurchaseStarter
import com.playground.feature_purchase_impl.starter.PurchaseStarterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PurchaseFeatureModule {

    @PerFeature
    @Binds
    abstract fun purchaseStarter(impl: PurchaseStarterImpl): PurchaseStarter
}