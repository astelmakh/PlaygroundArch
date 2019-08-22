package com.playground.feature_purchase_impl.di

import com.playground.corenavigation.di.CoreNavigationApi
import com.playground.coreutils.di.general.PerFeature
import dagger.Component

@Component(dependencies = [PurchaseFeatureDependencies::class])
abstract class PurchaseFeatureComponent {

    @Component(dependencies = [CoreNavigationApi::class])
    @PerFeature
    interface PurchaseFeatureDependenciesComponent : PurchaseFeatureDependencies

    companion object {

        @Volatile private var component: PurchaseFeatureComponent? = null

        fun initAndGet(purchaseFeatureDependencies: PurchaseFeatureDependencies): PurchaseFeatureComponent {
            val componentLocal = component
            return componentLocal ?: synchronized(this) {
                componentLocal ?: DaggerPurchaseFeatureComponent.builder()
                    .purchaseFeatureDependencies(purchaseFeatureDependencies)
                    .build().apply { component = this }
            }
        }

        fun get(): PurchaseFeatureComponent {
            return component?.let { it }
                ?: throw RuntimeException("You must call 'initAndGet(showCaseFeatureDependencies: ShowCaseFeatureDependencies)' method")
        }
    }
}