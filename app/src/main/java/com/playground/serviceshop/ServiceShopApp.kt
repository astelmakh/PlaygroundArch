package com.playground.serviceshop

import android.app.Application
import com.arellomobile.mvp.RegisterMoxyReflectorPackages
import com.playground.core_navigation_impl.FeatureInitializer
import com.playground.core_navigation_impl.di.CoreNavigationComponent
import com.playground.coreutils.di.AppComponent
import com.playground.featureshowcase.di.ShowCaseFeatureInitializer

@RegisterMoxyReflectorPackages(value = ["com.playground.featureshowcase"])
class ServiceShopApp : Application(), ShowCaseFeatureInitializer {

    override fun onCreate() {
        super.onCreate()

        AppComponent.init(this)

        val navigationComponent = CoreNavigationComponent.get()
        val globalNavigator = navigationComponent.globalNavigator()
        val globalNavigatorHolder = navigationComponent.globalNavigatorHolder()

        globalNavigatorHolder.setNavigator(globalNavigator)
    }

    override fun warmUpShowCaseFeature() {
        // initialize feature dependencies
        FeatureInitializer.getShowCaseFeature()
    }
}