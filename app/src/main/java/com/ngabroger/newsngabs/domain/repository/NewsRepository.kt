package com.ngabroger.newsngabs.domain.repository

import com.ngabroger.newsngabs.data.model.ArticlesItem
import com.ngabroger.newsngabs.data.model.NewsResponse
import com.ngabroger.newsngabs.utils.Result
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getAllNews(): Flow<Result<List<ArticlesItem>>>

}