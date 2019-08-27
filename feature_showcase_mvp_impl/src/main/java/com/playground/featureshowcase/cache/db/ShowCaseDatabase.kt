package com.playground.featureshowcase.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.playground.featureshowcase.cache.dao.CachedShowCaseDao
import com.playground.featureshowcase.cache.model.CachedShowCase

@Database(entities = [CachedShowCase::class], version = 1)
abstract class ShowCaseDatabase : RoomDatabase() {

    abstract fun showCaseDao(): CachedShowCaseDao
}