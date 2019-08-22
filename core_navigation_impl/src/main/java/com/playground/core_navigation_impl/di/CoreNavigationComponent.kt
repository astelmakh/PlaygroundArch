package com.playground.core_navigation_impl.di

import android.content.Context
import com.playground.corenavigation.di.CoreNavigationApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreNavigationModule::class])
abstract class CoreNavigationComponent : CoreNavigationApi {

    companion object {
        @Volatile
        private var component: CoreNavigationComponent? = null

        fun get(context: Context): CoreNavigationComponent {
            val componentLocal = component
            return componentLocal ?: synchronized(this) {
                componentLocal ?: DaggerCoreNavigationComponent.builder()
                    .coreNavigationModule(CoreNavigationModule(context))
                    .build().apply { component = this }
            }
        }
    }
}