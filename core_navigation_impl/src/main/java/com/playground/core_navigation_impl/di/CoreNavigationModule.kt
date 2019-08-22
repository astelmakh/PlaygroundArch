package com.playground.core_navigation_impl.di

import android.content.Context
import com.playground.core_navigation_impl.NavigatorImpl
import com.playground.corenavigation.IntentResolverMap
import com.playground.corenavigation.Navigator
import com.playground.feature_purchase_impl.di.PurchaseScreenNavigationModule
import com.playground.featureshowcase.di.ShowCaseScreenNavigationModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ShowCaseScreenNavigationModule::class, PurchaseScreenNavigationModule::class])
class CoreNavigationModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideNavigator(intentResolvers: IntentResolverMap): Navigator {
        return NavigatorImpl(intentResolvers, context)
    }
}