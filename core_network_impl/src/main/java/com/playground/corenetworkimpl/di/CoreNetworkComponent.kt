package com.playground.corenetworkimpl.di

import com.playground.corenetworkapi.di.CoreNetworkApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
abstract class CoreNetworkComponent : CoreNetworkApi {

    companion object {
        private lateinit var component: CoreNetworkComponent

        fun get(): CoreNetworkComponent {
            return if (::component.isInitialized) {
                component
            } else {
                DaggerCoreNetworkComponent.builder().build().apply { component = this }
            }
        }
    }
}