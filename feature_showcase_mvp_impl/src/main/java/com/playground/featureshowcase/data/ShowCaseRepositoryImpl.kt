package com.playground.featureshowcase.data

import com.playground.featureshowcase.data.model.ShowCaseEntity
import com.playground.featureshowcase.data.repository.ShowCaseDataStore
import com.playground.featureshowcase.di.qualifier.CacheDataStore
import com.playground.featureshowcase.di.qualifier.CreatorDataStore
import com.playground.featureshowcase.domain.data.ShowCaseRepository
import com.playground.featureshowcase.domain.model.ShowCaseItem
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class ShowCaseRepositoryImpl
@Inject constructor(
    @CacheDataStore private val cacheDataStore: ShowCaseDataStore,
    @CreatorDataStore private val creatorDataStore: ShowCaseDataStore,
    private val mapper: ShowCaseEntity.Mapper
) :
    ShowCaseRepository {

    override fun getInfo(id: Long): Maybe<ShowCaseItem> {
        return cacheDataStore.getInfo().flatMapMaybe { allCachedItems ->
            val cachedItem = allCachedItems.firstOrNull { it.id == id }
            cachedItem?.let { Maybe.just(mapper.mapFromEntity(it)) } ?: Maybe.empty()
        }
    }

    override fun getInfo(isUseCache: Boolean, count: Int?): Single<List<ShowCaseItem>> {
        val clearCacheCompletable = if (!isUseCache) {
            cacheDataStore.clearInfo()
        } else {
            Completable.complete()
        }
        return cacheDataStore.isCached()
            .flatMap { isCached ->
                if (isCached && isUseCache) {
                    cacheDataStore.getInfo(count)
                } else {
                    clearCacheCompletable
                        .andThen(creatorDataStore.getInfo(count))
                        .flatMapCompletable {
                            cacheDataStore.saveInfo(it)
                        }
                        .andThen(cacheDataStore.getInfo(count))
                }
            }
            .map { it -> it.map { mapper.mapFromEntity(it) } }
    }
}