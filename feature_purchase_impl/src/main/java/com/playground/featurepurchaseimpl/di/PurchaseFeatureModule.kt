package com.playground.featurepurchaseimpl.di

import com.playground.coreutils.di.general.PerFeature
import com.playground.featurepurchaseapi.starter.PurchaseStarter
import com.playground.featurepurchaseimpl.starter.PurchaseStarterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PurchaseFeatureModule {

    @PerFeature
    @Binds
    abstract fun purchaseStarter(impl: PurchaseStarterImpl): PurchaseStarter
}