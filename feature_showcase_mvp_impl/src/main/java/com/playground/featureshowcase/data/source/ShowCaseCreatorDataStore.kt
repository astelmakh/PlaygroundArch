package com.playground.featureshowcase.data.source

import com.playground.featureshowcase.data.model.ShowCaseEntity
import com.playground.featureshowcase.data.repository.ShowCaseDataStore
import com.playground.featureshowcase.domain.data.ShowCaseImageProvider
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import kotlin.math.max

class ShowCaseCreatorDataStore
@Inject constructor(private val imageProvider: ShowCaseImageProvider) : ShowCaseDataStore {

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun getInfo(count: Int?): Single<List<ShowCaseEntity>> {
        return Observable.range(1, max(count ?: LOAD_LIMIT, LOAD_LIMIT))
            .flatMap { itemIndex ->
                imageProvider.getImage()
                    .map { url ->
                        generateShowCaseTemplate(
                            itemIndex
                        ).copy(image = url)
                    }
                    .defaultIfEmpty(
                        generateShowCaseTemplate(
                            itemIndex
                        )
                    )
                    .toObservable()
            }
            .toList()
    }

    override fun saveInfo(info: List<ShowCaseEntity>): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearInfo(): Completable {
        throw UnsupportedOperationException()
    }

    companion object {
        private const val LOAD_LIMIT = 15
        private val TIME_CREATE_FRAME = System.currentTimeMillis().let { it - 100000..it }

        private fun generateShowCaseTemplate(index: Int): ShowCaseEntity {
            return ShowCaseEntity(title = "ShowCase $index",
                subtitle = "Description $index",
                createdTime = TIME_CREATE_FRAME.random())
        }
    }
}