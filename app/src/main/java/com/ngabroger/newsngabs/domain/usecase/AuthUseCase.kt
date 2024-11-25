package com.ngabroger.newsngabs.domain.usecase

import com.ngabroger.newsngabs.data.model.LoginResult
import com.ngabroger.newsngabs.domain.repository.AuthRepository
import com.ngabroger.newsngabs.utils.Result
import kotlinx.coroutines.flow.Flow

class AuthUseCase (private val authRepository: AuthRepository) {


    suspend operator fun invoke(email_or_phone: String, password: String): Flow<Result<List<LoginResult>>> {
        return authRepository.login(email_or_phone, password)
    }

    suspend fun getAuthToken(): String? {
        return authRepository.getAuthToken()
    }



}