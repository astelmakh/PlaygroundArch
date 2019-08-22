package com.playground.featureshowcase.domain.gateway

import com.playground.featureshowcase.domain.ShowCaseGateway
import com.playground.featureshowcase.domain.data.ShowCaseImageProvider
import com.playground.featureshowcase.domain.model.ShowCaseItem
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ShowCaseGatewayImpl
@Inject constructor(private val imageProvider: ShowCaseImageProvider) : ShowCaseGateway {

    override fun getInfo(count: Int?): Single<List<ShowCaseItem>> {
        return Observable.range(1, Math.max(count ?: LOAD_LIMIT, LOAD_LIMIT))
            .flatMap { itemIndex ->
                imageProvider.getImage()
                    .map { url ->
                        generateShowCaseTemplate(itemIndex).copy(image = url)
                    }
                    .defaultIfEmpty(generateShowCaseTemplate(itemIndex))
                    .toObservable()
            }
            .toList()
    }

    companion object {
        private const val LOAD_LIMIT = 15
        private val TIME_CREATE_FRAME = System.currentTimeMillis().let { it - 100000..it }

        private fun generateShowCaseTemplate(index: Int): ShowCaseItem {
            TIME_CREATE_FRAME.random()
            return ShowCaseItem("ShowCase $index", "Description $index", TIME_CREATE_FRAME.random())
        }
    }
}