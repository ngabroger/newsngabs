package com.ngabroger.newsngabs.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.ngabroger.newsngabs.core.base.ViewModelBaseImpl
import com.ngabroger.newsngabs.data.model.LoginResult
import com.ngabroger.newsngabs.domain.usecase.AuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import com.ngabroger.newsngabs.utils.Result
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModelImpl(private val authUseCase: AuthUseCase): ViewModelBaseImpl(), AuthViewModel {
    private val _user = MutableStateFlow<Result<List<LoginResult>>>(Result.Loading)
    val user : StateFlow<Result<List<LoginResult>>> = _user

    private val _token = MutableStateFlow<String?>(null)
    val token : StateFlow<String?> = _token

    override fun login(email: String, password: String) {
    viewModelScope.launch{
        authUseCase(email,password).collect{
            _user.value = it
        }
    }
    }

    override suspend fun fetchToken(): String? {
        viewModelScope.launch{
            _token.value = authUseCase.getAuthToken()
        }
        return token.toString()
    }
}