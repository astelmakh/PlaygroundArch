package com.playground.featureshowcase.domain.model

data class ShowCaseItem(val title: String,
                        val subtitle: String,
                        val createdTime: Long,
                        val image: String? = null)