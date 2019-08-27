package com.playground.featureshowcase.data.repository

import com.playground.featureshowcase.data.model.ShowCaseEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ShowCaseDataStore {

    fun isCached(): Single<Boolean>

    fun getInfo(count: Int? = null): Single<List<ShowCaseEntity>>

    fun saveInfo(info: List<ShowCaseEntity>): Completable

    fun clearInfo(): Completable
}