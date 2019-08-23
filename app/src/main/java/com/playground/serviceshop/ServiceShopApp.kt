package com.playground.serviceshop

import android.app.Application
import com.arellomobile.mvp.RegisterMoxyReflectorPackages
import com.playground.core_navigation_impl.di.CoreNavigationComponent
import com.playground.corenetworkimpl.di.CoreNetworkComponent
import com.playground.featureshowcase.di.DaggerShowCaseFeatureComponent_ShowCaseFeatureDependenciesComponent
import com.playground.featureshowcase.di.ShowCaseFeatureComponent

@RegisterMoxyReflectorPackages(value = ["com.playground.featureshowcase"])
class ServiceShopApp : Application() {

    override fun onCreate() {
        super.onCreate()

        ShowCaseFeatureComponent.initAndGet(
            DaggerShowCaseFeatureComponent_ShowCaseFeatureDependenciesComponent.builder()
                .coreNetworkApi(CoreNetworkComponent.get())
                .coreNavigationApi(CoreNavigationComponent.get())
                .build()
        )
    }
}