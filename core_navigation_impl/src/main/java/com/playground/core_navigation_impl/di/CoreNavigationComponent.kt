package com.playground.core_navigation_impl.di

import com.playground.corenavigation.di.CoreNavigationApi
import com.playground.coreutils.di.AppApi
import com.playground.coreutils.di.AppComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppApi::class],
    modules = [CoreNavigationModule::class]
)
abstract class CoreNavigationComponent : CoreNavigationApi {

    companion object {
        @Volatile
        private var component: CoreNavigationComponent? = null

        fun get(): CoreNavigationComponent {
            val componentLocal = component
            return componentLocal ?: synchronized(this) {
                componentLocal ?: DaggerCoreNavigationComponent.builder()
                    .appApi(AppComponent.get())
                    .build().apply { component = this }
            }
        }
    }
}