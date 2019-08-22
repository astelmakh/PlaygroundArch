package com.playground.featureshowcase.di

import com.playground.corenavigation.Navigator
import com.playground.corenetworkapi.data.CatApi

interface ShowCaseFeatureDependencies {

    fun catApi(): CatApi
    fun navigator(): Navigator
}