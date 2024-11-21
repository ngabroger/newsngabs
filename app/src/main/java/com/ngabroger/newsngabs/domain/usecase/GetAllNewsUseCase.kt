package com.ngabroger.newsngabs.domain.usecase

import android.util.Log
import com.ngabroger.newsngabs.data.model.ArticlesItem
import com.ngabroger.newsngabs.domain.repository.NewsRepository
import com.ngabroger.newsngabs.utils.Result
import kotlinx.coroutines.flow.Flow

class GetAllNewsUseCase (private val repository: NewsRepository){
     operator fun invoke() : Flow<Result<List<ArticlesItem>>>{
        return repository.getAllNews()
    }

}