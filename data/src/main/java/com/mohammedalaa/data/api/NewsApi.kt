package com.mohammedalaa.data.api

import com.mohammedalaa.data.model.NewsResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("svc/mostpopular/v2/viewed/7.json")
    suspend fun getNews(
        @Query("api-key") apiKey: String,
    ): NewsResponseEntity

}

internal const val BASE_URL = "https://api.nytimes.com/"
