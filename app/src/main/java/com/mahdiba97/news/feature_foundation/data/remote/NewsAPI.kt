package com.mahdiba97.news.feature_foundation.data.remote

import com.mahdiba97.news.feature_foundation.data.remote.dto.NewsDto
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NewsAPI {
    @GET("everything")
    suspend fun getSearchNews(@QueryMap filter: HashMap<String, String>): NewsDto

    @GET("top-headlines")
    suspend fun getTopNews(@QueryMap filter: HashMap<String, String>): NewsDto

    companion object {
        const val BASE_RUL = "https://newsapi.org/v2/"
        const val API_KEY = "a6f54b0da7954ee58431b5b09958b1f1"
    }
}