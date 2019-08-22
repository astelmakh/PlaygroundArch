package com.playground.featureshowcase.domain.data

import io.reactivex.Maybe

interface ShowCaseImageProvider {

    fun getImage(): Maybe<String>
}