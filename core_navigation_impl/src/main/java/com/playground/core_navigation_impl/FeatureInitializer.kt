package com.playground.core_navigation_impl

import com.playground.core_navigation_impl.di.CoreNavigationComponent
import com.playground.corenetworkimpl.di.CoreNetworkComponent
import com.playground.coreutils.di.AppComponent
import com.playground.feature_purchase_impl.di.DaggerPurchaseFeatureComponent_PurchaseFeatureDependenciesComponent
import com.playground.feature_purchase_impl.di.PurchaseFeatureComponent
import com.playground.featureshowcase.di.DaggerShowCaseFeatureComponent_ShowCaseFeatureDependenciesComponent
import com.playground.featureshowcase.di.ShowCaseFeatureComponent

object FeatureInitializer {

    fun getShowCaseFeature(): ShowCaseFeatureComponent {
        return ShowCaseFeatureComponent.initAndGet(
            DaggerShowCaseFeatureComponent_ShowCaseFeatureDependenciesComponent.builder()
                .coreNetworkApi(CoreNetworkComponent.get())
                .coreNavigationApi(CoreNavigationComponent.get())
                .appApi(AppComponent.get())
                .build())
    }

    fun getPurchaseFeature(): PurchaseFeatureComponent {
        return PurchaseFeatureComponent.initAndGet(DaggerPurchaseFeatureComponent_PurchaseFeatureDependenciesComponent.builder()
            .coreNavigationApi(CoreNavigationComponent.get())
            .build())
    }
}