package com.playground.serviceshop.di

import com.playground.corenavigation.Navigator
import com.playground.feature_purchase_impl.di.PurchaseScreenNavigationModule
import com.playground.featureshowcase.di.ShowCaseScreenNavigationModule
import com.playground.serviceshop.NavigatorImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ShowCaseScreenNavigationModule::class, PurchaseScreenNavigationModule::class])
abstract class CoreNavigationModule {

    @Singleton
    @Binds
    abstract fun provideNavigator(impl: NavigatorImpl): Navigator
}