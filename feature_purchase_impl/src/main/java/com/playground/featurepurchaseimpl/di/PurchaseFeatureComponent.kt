package com.playground.featurepurchaseimpl.di

import com.playground.corenavigation.di.CoreNavigationApi
import com.playground.coreutils.di.general.PerFeature
import com.playground.featurepurchaseapi.PurchaseFeatureApi
import dagger.Component

@Component(dependencies = [PurchaseFeatureDependencies::class], modules = [PurchaseFeatureModule::class])
@PerFeature
abstract class PurchaseFeatureComponent : PurchaseFeatureApi {

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
                ?: throw RuntimeException("You must call 'initAndGet(purchaseFeatureDependencies: PurchaseFeatureDependencies)' method")
        }
    }
}