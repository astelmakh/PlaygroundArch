package com.playground.serviceshop.di

import android.content.Context
import com.playground.corenavigation.di.CoreNavigationApi
import com.playground.feature_purchase_impl.di.PurchaseScreenNavigationModule
import com.playground.featureshowcase.di.ShowCaseScreenNavigationModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [AppModule::class, CoreNavigationModule::class]
)
@Singleton
abstract class AppComponent : CoreNavigationApi {

    companion object {
        @Volatile
        private var component: AppComponent? = null

        fun get(context: Context): AppComponent {
            val componentLocal = component
            return componentLocal ?: synchronized(this) {
                componentLocal ?: DaggerAppComponent.builder()
                    .appModule(AppModule(context))
                    .build().apply { component = this }
            }
        }
    }
}