package com.ngabroger.newsngabs.domain.repository

import com.ngabroger.newsngabs.data.model.LoginResult
import com.ngabroger.newsngabs.utils.Result
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String,password: String): Flow<Result<List<LoginResult>>>
    suspend fun getAuthToken(): String?

}