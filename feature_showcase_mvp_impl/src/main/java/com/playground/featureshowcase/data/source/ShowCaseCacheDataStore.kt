package com.playground.featureshowcase.data.source

import com.playground.featureshowcase.data.model.ShowCaseEntity
import com.playground.featureshowcase.data.repository.ShowCaseCache
import com.playground.featureshowcase.data.repository.ShowCaseDataStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ShowCaseCacheDataStore
@Inject constructor(private val cache: ShowCaseCache) : ShowCaseDataStore {

    override fun isCached(): Single<Boolean> {
        return cache.isCachePresent()
    }

    override fun getInfo(count: Int?): Single<List<ShowCaseEntity>> {
        return cache.getInfo(count)
    }

    override fun saveInfo(info: List<ShowCaseEntity>): Completable {
        return cache.saveInfo(info)
    }

    override fun clearInfo(): Completable {
        return cache.clearInfo()
    }
}