package com.playground.featureshowcase.cache

import com.playground.featureshowcase.cache.db.ShowCaseDatabase
import com.playground.featureshowcase.cache.model.CachedShowCase
import com.playground.featureshowcase.data.model.ShowCaseEntity
import com.playground.featureshowcase.data.repository.ShowCaseCache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ShowCaseCacheImpl
@Inject constructor(
    private val database: ShowCaseDatabase,
    private val mapper: CachedShowCase.Mapper
) : ShowCaseCache {

    override fun isCachePresent(): Single<Boolean> {
        return database.showCaseDao().getAll().map { it.any() }
    }

    override fun getInfo(count: Int?): Single<List<ShowCaseEntity>> {
        return database.showCaseDao().getAll().map { list ->
            count?.let {
                list.take(it)
            } ?: list
        }
            .map { it.map { mapper.mapToEntity(it) } }
    }

    override fun saveInfo(info: List<ShowCaseEntity>): Completable {
        return Completable.defer {
            info.forEach { database.showCaseDao().insert(mapper.mapFromEntity(it)) }
            Completable.complete()
        }
    }

    override fun clearInfo(): Completable {
        return database.showCaseDao().deleteAll()
    }
}