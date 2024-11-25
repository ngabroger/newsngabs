package com.ngabroger.newsngabs.data.api

import com.ngabroger.newsngabs.BuildConfig
import com.ngabroger.newsngabs.data.storage.AuthPreference
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.mp.KoinPlatform.getKoin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiConfig {
    fun getApiService(): ApiService{
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val authPreference : AuthPreference= getKoin().get()
        val authInterceptor = AuthInterceptor(authPreference)
        val client = OkHttpClient.Builder()
          .addInterceptor(loggingInterceptor)

        if (!client.interceptors().contains(authInterceptor)) {
            client.addInterceptor(authInterceptor)
        }
        val retrofit= Retrofit.Builder()
          .baseUrl(BuildConfig.DICODING_API)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
        return retrofit.create(ApiService::class.java)
    }
}