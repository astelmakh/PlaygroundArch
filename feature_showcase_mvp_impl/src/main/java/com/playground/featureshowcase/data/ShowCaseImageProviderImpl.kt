package com.playground.featureshowcase.data

import com.playground.corenetworkapi.data.CatApi
import com.playground.featureshowcase.domain.data.ShowCaseImageProvider
import io.reactivex.Maybe
import javax.inject.Inject

class ShowCaseImageProviderImpl
@Inject constructor(private val catApi: CatApi) : ShowCaseImageProvider {

    override fun getImage(): Maybe<String> {
        return catApi.getRandomImage()
            .flatMapMaybe { response ->
                (response.url ?: "").let { Maybe.just(it) } ?: Maybe.empty()
            }
    }
}