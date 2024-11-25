package com.ngabroger.newsngabs.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import java.io.File

object DataStoreFactory {
    fun createDataStore(context: Context, name: String): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {
                File(context.filesDir, "$name.preferences_pb")
            }
        )
    }
}