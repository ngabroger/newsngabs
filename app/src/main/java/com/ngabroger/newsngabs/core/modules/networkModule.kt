package com.ngabroger.newsngabs.core.modules

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.ngabroger.newsngabs.data.api.ApiConfig
import com.ngabroger.newsngabs.data.api.ApiService
import com.ngabroger.newsngabs.data.repository.AuthRepositoryImpl
import com.ngabroger.newsngabs.data.storage.AuthPreference
import com.ngabroger.newsngabs.domain.repository.AuthRepository
import com.ngabroger.newsngabs.domain.repository.TokenStorage
import com.ngabroger.newsngabs.domain.usecase.AuthUseCase
import com.ngabroger.newsngabs.presentation.viewmodel.AuthViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module{
    single<ApiService>{ ApiConfig.getApiService()}
    single<AuthRepository>{ AuthRepositoryImpl(get(),get()) }
    single{ AuthUseCase(get())}

    viewModel { AuthViewModelImpl(get()) }
}