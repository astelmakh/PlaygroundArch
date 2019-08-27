package com.playground.featureshowcase.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.playground.featureshowcase.cache.db.ShowCaseConstants
import com.playground.featureshowcase.cache.model.CachedShowCase
import io.reactivex.Completable
import io.reactivex.Single

@Dao
abstract class CachedShowCaseDao {

    @Query(ShowCaseConstants.QUERY_SHOWCASE_CONTENT)
    abstract fun getAll(): Single<List<CachedShowCase>>

    @Query(ShowCaseConstants.DELETE_ALL)
    abstract fun deleteAll(): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(item: CachedShowCase)
}