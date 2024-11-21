package com.ngabroger.newsngabs.data.api

import com.ngabroger.newsngabs.BuildConfig
import com.ngabroger.newsngabs.data.model.NewsResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything?q=bitcoin&sortBy=publishedAt")
    suspend fun getNews(@Query("apiKey") apiKey: String= BuildConfig.API_KEY): Response<NewsResponse>
}