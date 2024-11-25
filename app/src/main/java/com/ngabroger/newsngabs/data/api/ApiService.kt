package com.ngabroger.newsngabs.data.api

import com.ngabroger.newsngabs.BuildConfig
import com.ngabroger.newsngabs.data.model.LoginResponse
import com.ngabroger.newsngabs.data.model.LoginResult
import com.ngabroger.newsngabs.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.Field

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService{


    @POST("login")
    suspend fun login(@Field("email") email : String,
                      @Field("password") password : String) : Response<LoginResponse>

}