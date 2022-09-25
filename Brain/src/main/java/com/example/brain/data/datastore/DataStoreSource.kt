package com.example.brain.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("pref")

class DataStoreSource @Inject constructor(
    private val context: Context
) {
    /**First time state*/
    private val isFirstTimePref = booleanPreferencesKey("IS_FIRST_TIME")
    val isFirstTime = context.dataStore.data.map {
        it[isFirstTimePref] ?: true
    }
    suspend fun saveIsFirstTimeState(isFirstTimeState: Boolean) = context.dataStore.edit {
        it[isFirstTimePref] = isFirstTimeState
    }
}