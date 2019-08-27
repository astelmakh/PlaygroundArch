package com.playground.featureshowcase.di.module

import android.content.Context
import androidx.room.Room
import com.playground.coreutils.di.general.PerFeature
import com.playground.featureshowcase.cache.db.ShowCaseConstants
import com.playground.featureshowcase.cache.db.ShowCaseDatabase
import dagger.Module
import dagger.Provides

@Module
class ShowCaseFeatureDatabaseModule {

    @Provides
    @PerFeature
    fun provideShowCaseDatabase(context: Context): ShowCaseDatabase {
        return Room.databaseBuilder(
            context,
            ShowCaseDatabase::class.java,
            ShowCaseConstants.DATABASE_NAME
        ).allowMainThreadQueries()
            .build()
    }
}