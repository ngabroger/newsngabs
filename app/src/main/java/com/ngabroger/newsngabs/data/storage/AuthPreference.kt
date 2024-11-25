package com.ngabroger.newsngabs.data.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ngabroger.newsngabs.domain.repository.TokenStorage
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class AuthPreference (private val dataStore: DataStore<Preferences>):TokenStorage{
   companion object{
         private val AUTH_TOKEN_KEY = stringPreferencesKey("auth_token")
       private val AUTH_NAME_KEY = stringPreferencesKey("auth_name")
   }

    override suspend fun saveToken(token: String,name : String) {
        dataStore.edit {
            it[AUTH_TOKEN_KEY] = token
            it[AUTH_NAME_KEY] = name
        }
    }

    override suspend fun getToken(): String? {
        return  dataStore.data.map {
            it[AUTH_TOKEN_KEY]
        }.firstOrNull()
    }
}