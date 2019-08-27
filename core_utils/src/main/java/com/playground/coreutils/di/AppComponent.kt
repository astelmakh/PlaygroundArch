package com.playground.coreutils.di

import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
abstract class AppComponent : AppApi {

    companion object {
        @Volatile
        private var component: AppComponent? = null

        fun init(context: Context): AppComponent {
            val componentLocal = component
            return componentLocal ?: synchronized(this) {
                componentLocal ?: DaggerAppComponent.builder()
                    .appModule(AppModule(context))
                    .build().apply { component = this }
            }
        }

        fun get(): AppComponent {
            return component
                ?: throw RuntimeException("You must call 'init(context: Context)' method")
        }
    }
}