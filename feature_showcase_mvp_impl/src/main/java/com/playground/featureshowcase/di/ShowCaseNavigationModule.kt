package com.playground.featureshowcase.di

import com.playground.coreutils.di.general.PerFeature
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class ShowCaseNavigationModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @PerFeature
    @ShowCaseNavigation
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    @PerFeature
    @ShowCaseNavigation
    fun provideNavigationHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}