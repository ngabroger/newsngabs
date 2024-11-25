package com.ngabroger.newsngabs.core.modules

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.ngabroger.newsngabs.data.storage.AuthPreference
import com.ngabroger.newsngabs.data.storage.DataStoreFactory.createDataStore
import com.ngabroger.newsngabs.domain.repository.TokenStorage
import org.koin.dsl.module

val dataStore= module{
    single { createDataStore(get(), "auth_prefs") }
    single<TokenStorage>{ AuthPreference(get()) }
}