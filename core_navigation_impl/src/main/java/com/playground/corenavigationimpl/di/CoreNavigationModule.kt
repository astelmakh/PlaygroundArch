package com.playground.corenavigationimpl.di

import com.playground.corenavigationimpl.GlobalNavigatorImpl
import com.playground.corenavigation.GlobalNavigation
import com.playground.corenavigation.GlobalNavigator
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class CoreNavigationModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    @GlobalNavigation
    fun provideNavigator(impl: GlobalNavigatorImpl): GlobalNavigator {
        return impl
    }

    @Singleton
    @Provides
    @GlobalNavigation
    fun provideGlobalRouter(): Router {
        return cicerone.router
    }

    @Singleton
    @Provides
    @GlobalNavigation
    fun provideGlobalNavigatorHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}