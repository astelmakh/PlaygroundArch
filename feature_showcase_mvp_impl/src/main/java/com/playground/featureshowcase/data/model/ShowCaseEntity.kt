package com.playground.featureshowcase.data.model

import com.playground.featureshowcase.domain.model.ShowCaseItem
import javax.inject.Inject
import com.playground.featureshowcase.domain.mapper.Mapper as MapperInterface

data class ShowCaseEntity(
    val id: Long? = null,
    val title: String,
    val subtitle: String,
    val createdTime: Long,
    val image: String? = null
) {

    class Mapper @Inject constructor() : MapperInterface<ShowCaseEntity, ShowCaseItem> {

        override fun mapFromEntity(type: ShowCaseEntity): ShowCaseItem {
            return ShowCaseItem(
                type.id ?: -1,
                type.title,
                type.subtitle,
                type.createdTime,
                type.image
            )
        }

        override fun mapToEntity(type: ShowCaseItem): ShowCaseEntity {
            return ShowCaseEntity(type.id, type.title, type.subtitle, type.createdTime, type.image)
        }
    }
}