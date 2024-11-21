package com.ngabroger.newsngabs.core.modules


import com.ngabroger.newsngabs.data.api.ApiConfig
import com.ngabroger.newsngabs.data.api.ApiService
import com.ngabroger.newsngabs.data.repository.NewsRepositoryImpl
import com.ngabroger.newsngabs.domain.repository.NewsRepository
import com.ngabroger.newsngabs.domain.usecase.GetAllNewsUseCase

import com.ngabroger.newsngabs.presentation.viewmodel.NewsViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModule = module{
    single <ApiService>{ ApiConfig.getApiService() }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    single{ GetAllNewsUseCase(get()) }
    viewModel{ NewsViewModelImpl(get()) }
}