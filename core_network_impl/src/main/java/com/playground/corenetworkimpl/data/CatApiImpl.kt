package com.playground.corenetworkimpl.data

import com.playground.corenetworkapi.data.CatApi
import com.playground.corenetworkapi.data.CatApiResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Inject

class CatApiImpl
@Inject constructor() : CatApi {

    override fun getRandomImage(
        format: String,
        type: String,
        size: String,
        resultsPerPage: Int
    ): Single<CatApiResponse> {
        return service.getRandomImage()
    }

    companion object {
        private var retrofit = Retrofit.Builder()
            .baseUrl("https://thecatapi.com/api/")
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.createWithScheduler(
                    Schedulers.io()
                )
            )
            .addConverterFactory(
                SimpleXmlConverterFactory.createNonStrict(
                    Persister(
                        AnnotationStrategy()
                    )
                )
            )
            .build()

        private val service = retrofit.create(CatApi::class.java)
    }
}