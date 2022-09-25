package com.example.brain.data.repository

import com.example.brain.data.datastore.DataStoreSource
import com.example.brain.data.local.LocalDataSource
import com.example.brain.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val dataStoreSource: DataStoreSource
) {
    /**First Time state*/
    fun isFirstTimeOpenApp() = dataStoreSource.isFirstTime

    /**Save First Time state*/
    suspend fun setIsFirstTimeOpenApp(state:Boolean) = dataStoreSource.saveIsFirstTimeState(state)
}