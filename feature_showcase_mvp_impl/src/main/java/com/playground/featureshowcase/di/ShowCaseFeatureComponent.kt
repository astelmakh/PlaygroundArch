package com.playground.featureshowcase.di

import com.playground.corenavigation.di.CoreNavigationApi
import com.playground.corenetworkapi.di.CoreNetworkApi
import com.playground.coreutils.di.AppApi
import com.playground.coreutils.di.general.PerFeature
import com.playground.featureshowcase.presentation.ShowCaseActivity
import com.playground.featureshowcase.presentation.details.di.ShowCaseDetailsScreenComponent
import com.playground.featureshowcase.presentation.details.di.ShowCaseDetailsScreenModule
import com.playground.featureshowcase.presentation.list.di.ShowCaseListScreenComponent
import com.playground.featureshowcase.presentation.list.di.ShowCaseListScreenModule
import com.playground.featureshowcasemvpapi.ShowCaseFeatureApi
import dagger.Component

@Component(
    dependencies = [ShowCaseFeatureDependencies::class],
    modules = [ShowCaseFeatureModule::class]
)
@PerFeature
abstract class ShowCaseFeatureComponent : ShowCaseFeatureApi {

    fun resetComponent() {
        component = null
    }

    @Component(dependencies = [CoreNetworkApi::class, CoreNavigationApi::class, AppApi::class])
    @PerFeature
    interface ShowCaseFeatureDependenciesComponent : ShowCaseFeatureDependencies

    abstract fun showCaseListScreenComponent(module: ShowCaseListScreenModule): ShowCaseListScreenComponent
    abstract fun showCaseDetailsScreenComponent(module: ShowCaseDetailsScreenModule): ShowCaseDetailsScreenComponent

    abstract fun inject(where: ShowCaseActivity)

    companion object {

        @Volatile
        private var component: ShowCaseFeatureComponent? = null

        fun initAndGet(
            showCaseFeatureDependencies: ShowCaseFeatureDependencies
        ): ShowCaseFeatureComponent {
            val componentLocal = component
            return componentLocal ?: synchronized(this) {
                componentLocal ?: DaggerShowCaseFeatureComponent.builder()
                    .showCaseFeatureDependencies(showCaseFeatureDependencies)
                    .build().apply { component = this }
            }
        }

        fun get(): ShowCaseFeatureComponent {
            return component?.let { it }
                ?: throw RuntimeException("You must call 'initAndGet(showCaseFeatureDependencies: ShowCaseFeatureDependencies)' method")
        }
    }
}