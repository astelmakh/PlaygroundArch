package com.playground.corenetworkapi.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {

    @GET("images/get")
    fun getRandomImage(
        @Query("format") format: String = "xml",
        @Query("type") type: String = "jpg",
        @Query("size") size: String = "med",
        @Query("results_per_page") resultsPerPage: Int = 1
    ): Single<CatApiResponse>
}