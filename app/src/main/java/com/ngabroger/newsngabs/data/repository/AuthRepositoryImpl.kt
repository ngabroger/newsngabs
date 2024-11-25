package com.ngabroger.newsngabs.data.repository

import com.ngabroger.newsngabs.data.api.ApiService
import com.ngabroger.newsngabs.data.model.LoginResult
import com.ngabroger.newsngabs.domain.repository.AuthRepository
import com.ngabroger.newsngabs.domain.repository.TokenStorage
import com.ngabroger.newsngabs.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(private val apiService: ApiService, private val tokenStorage: TokenStorage):
    AuthRepository{


    override suspend fun login(
        email: String,
        password: String
    ): Flow<Result<List<LoginResult>>> {
      return flow{
          try {
              emit(Result.Loading)
              val response = apiService.login(email, password)
              if (response.isSuccessful){
                  val dataUser  = response.body()?.loginResult
                  if (dataUser== null){
                      emit(Result.Error("Login Failed"))
                      return@flow
                  }
                  tokenStorage.saveToken(dataUser.token.toString(), dataUser.name.toString())
                  emit(Result.Success(listOf(dataUser)))
              }else{
                  Result.Error("Login Failed")
              }
          }catch (e: Exception){
              emit(Result.Error("Exception occurred: ${e.message}"))
          }

      }

    }

    override suspend fun getAuthToken(): String? {
        return tokenStorage.getToken()
    }


}