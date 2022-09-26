package com.example.brain.data.repository

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.runtime.MutableState
import com.example.brain.data.datastore.DataStoreSource
import com.example.brain.data.local.LocalDataSource
import com.example.brain.data.remote.RemoteDataSource
import com.google.firebase.auth.AuthCredential
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

    /**Login with Google*/
    fun loginWithGoogle(launcher: ActivityResultLauncher<IntentSenderRequest>, loadingState: MutableState<Boolean>){
        remoteDataSource.login(launcher = launcher, loadingState = loadingState)
    }

    /**Login with Credential*/
    fun loginWithCredential(credential: AuthCredential) = remoteDataSource.loginWithCredential(credential)
}