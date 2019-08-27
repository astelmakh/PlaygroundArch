package com.playground.corenavigation.di

import com.playground.corenavigation.GlobalNavigation
import com.playground.corenavigation.GlobalNavigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface CoreNavigationApi {

    @GlobalNavigation
    fun globalRouter(): Router

    @GlobalNavigation
    fun globalNavigator(): GlobalNavigator

    @GlobalNavigation
    fun globalNavigatorHolder(): NavigatorHolder
}