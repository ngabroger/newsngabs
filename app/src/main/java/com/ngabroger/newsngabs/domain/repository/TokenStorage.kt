package com.ngabroger.newsngabs.domain.repository

interface TokenStorage {
    suspend fun saveToken(token: String,name : String)
    suspend fun getToken(): String?
}