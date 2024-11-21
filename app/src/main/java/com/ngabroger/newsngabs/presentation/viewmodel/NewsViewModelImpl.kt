package com.ngabroger.newsngabs.presentation.viewmodel

import android.util.Log
import com.ngabroger.newsngabs.data.model.ArticlesItem
import com.ngabroger.newsngabs.domain.usecase.GetAllNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import com.ngabroger.newsngabs.core.base.ViewModelBaseImpl
import com.ngabroger.newsngabs.utils.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class NewsViewModelImpl (private val newsUseCase: GetAllNewsUseCase): ViewModelBaseImpl(), NewsViewModel{
    private val _news = MutableStateFlow<Result<List<ArticlesItem>>>(Result.Loading)
    override val news: StateFlow<Result<List<ArticlesItem>>>   = _news

    init {
        getAllNews()
    }
    override fun getAllNews() {
        viewModelScope.launch(){
            newsUseCase().collect{
                _news.value = it
            }
        }
    }
//            newsUseCase().collect{ result ->
//                if (result is Result.Success){
//                    Log.d("NewsViewModelImpl", "getAllNews: ${result.data}")
//                    _notes.value = result
//                }else{
//
//                    _notes.value = Result.Error("Failed to get news")
//                }
//
//            }




}