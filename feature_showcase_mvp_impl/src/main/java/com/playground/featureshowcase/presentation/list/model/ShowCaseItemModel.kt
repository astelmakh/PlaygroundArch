package com.playground.featureshowcase.presentation.list.model

import com.playground.featureshowcase.domain.model.ShowCaseItem
import javax.inject.Inject

class ShowCaseItemModel(
    val title: String,
    val subtitle: String,
    val createdTime: Long,
    val image: String? = null
) {

    class Mapper
    @Inject constructor() {

        fun map(domain: ShowCaseItem): ShowCaseItemModel =
            ShowCaseItemModel(domain.title, domain.subtitle, domain.createdTime, domain.image)
    }
}