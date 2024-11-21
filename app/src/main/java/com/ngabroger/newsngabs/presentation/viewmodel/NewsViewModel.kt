package com.ngabroger.newsngabs.presentation.viewmodel

import com.ngabroger.newsngabs.data.model.ArticlesItem
import kotlinx.coroutines.flow.StateFlow
import com.ngabroger.newsngabs.utils.Result

interface NewsViewModel {
    val news : StateFlow<Result<List<ArticlesItem>>>
    fun getAllNews()
}