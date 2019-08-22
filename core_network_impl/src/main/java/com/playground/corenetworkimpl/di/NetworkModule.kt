package com.playground.corenetworkimpl.di

import com.playground.corenetworkapi.data.CatApi
import com.playground.corenetworkimpl.data.CatApiImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Singleton
    @Binds
    abstract fun provideCatApi(impl: CatApiImpl): CatApi
}