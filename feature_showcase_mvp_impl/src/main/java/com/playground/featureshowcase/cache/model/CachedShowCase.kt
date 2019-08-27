package com.playground.featureshowcase.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.playground.featureshowcase.cache.db.ShowCaseConstants
import com.playground.featureshowcase.data.model.ShowCaseEntity
import javax.inject.Inject
import com.playground.featureshowcase.domain.mapper.Mapper as MapperInterface

@Entity(tableName = ShowCaseConstants.TABLE_NAME)
data class CachedShowCase(

    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val title: String,
    val subtitle: String,
    val createdTime: Long,
    val image: String?
) {

    class Mapper @Inject constructor() : MapperInterface<ShowCaseEntity, CachedShowCase> {

        override fun mapFromEntity(type: ShowCaseEntity): CachedShowCase {
            return CachedShowCase(
                type.id ?: 0,
                type.title,
                type.subtitle,
                type.createdTime,
                type.image
            )
        }

        override fun mapToEntity(type: CachedShowCase): ShowCaseEntity {
            return ShowCaseEntity(type.id, type.title, type.subtitle, type.createdTime, type.image)
        }
    }
}