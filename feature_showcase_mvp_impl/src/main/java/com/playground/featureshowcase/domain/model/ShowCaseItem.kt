package com.playground.featureshowcase.domain.model

data class ShowCaseItem(
    val id: Long,
    val title: String,
    val subtitle: String,
    val createdTime: Long,
    val image: String? = null
)