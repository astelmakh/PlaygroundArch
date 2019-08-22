package com.playground.corenetworkapi.di

import com.playground.corenetworkapi.data.CatApi

interface CoreNetworkApi {

    fun catApi(): CatApi
}