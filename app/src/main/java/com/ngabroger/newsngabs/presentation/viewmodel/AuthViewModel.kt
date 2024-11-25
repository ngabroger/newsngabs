package com.ngabroger.newsngabs.presentation.viewmodel

interface AuthViewModel {
    fun login(email_or_phone: String, password: String)

    suspend fun fetchToken(): String?


}