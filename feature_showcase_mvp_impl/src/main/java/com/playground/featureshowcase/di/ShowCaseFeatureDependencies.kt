package com.playground.featureshowcase.di

import android.content.Context
import com.playground.corenavigation.GlobalNavigation
import com.playground.corenavigation.GlobalNavigator
import com.playground.corenetworkapi.data.CatApi
import ru.terrakok.cicerone.Router

interface ShowCaseFeatureDependencies {

    fun catApi(): CatApi

    @GlobalNavigation
    fun navigator(): GlobalNavigator

    @GlobalNavigation
    fun router(): Router

    fun context(): Context
}