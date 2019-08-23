package com.playground.core_navigation_impl.di

import com.playground.core_navigation_impl.NavigatorImpl
import com.playground.corenavigation.Navigator
import com.playground.feature_purchase_impl.di.PurchaseScreenNavigationModule
import com.playground.featureshowcase.di.ShowCaseScreenNavigationModule
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ShowCaseScreenNavigationModule::class, PurchaseScreenNavigationModule::class])
abstract class CoreNavigationModule {

    @Binds
    @Singleton
    abstract fun provideNavigator(impl: NavigatorImpl): Navigator
}