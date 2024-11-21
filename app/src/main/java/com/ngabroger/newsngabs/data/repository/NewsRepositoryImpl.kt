package com.ngabroger.newsngabs.data.repository

import android.util.Log
import com.ngabroger.newsngabs.data.api.ApiService
import com.ngabroger.newsngabs.data.model.ArticlesItem
import com.ngabroger.newsngabs.domain.repository.NewsRepository
import com.ngabroger.newsngabs.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(private val apiService: ApiService): NewsRepository {
    override fun getAllNews(): Flow<Result<List<ArticlesItem>>> {
        return flow {
            emit(Result.Loading)
            val response = apiService.getNews()
            if (response.isSuccessful){

                val articles = response.body()?.articles
                emit(Result.Success(articles!!))
            }else{
                Result.Error("Failed to get news")
            }
        }

    }
}