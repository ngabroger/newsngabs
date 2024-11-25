package com.ngabroger.newsngabs.data.api

import com.ngabroger.newsngabs.data.storage.AuthPreference
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor (private val authPreference: AuthPreference): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request= chain.request()
        val newRequest = request.newBuilder()
            .addHeader("Authorization", "Bearer ${runBlocking{ authPreference.getToken()}}")
        return chain.proceed(newRequest.build())
    }

}