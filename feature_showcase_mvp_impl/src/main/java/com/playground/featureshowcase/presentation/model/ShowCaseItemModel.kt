package com.playground.featureshowcase.presentation.model

import com.playground.featureshowcase.domain.model.ShowCaseItem
import javax.inject.Inject

class ShowCaseItemModel(
    val id: Long,
    val title: String,
    val subtitle: String,
    val createdTime: Long,
    val image: String? = null
) {

    class Mapper
    @Inject constructor() {

        fun map(domain: ShowCaseItem): ShowCaseItemModel =
            ShowCaseItemModel(domain.id, domain.title, domain.subtitle, domain.createdTime, domain.image)
    }
}