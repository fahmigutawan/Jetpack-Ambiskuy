package com.example.ambiskuy.viewmodel

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.brain.data.repository.Repository
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {
    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val isLoading = mutableStateOf(false)
    val showFailedGoogleLoginSnackbar = mutableStateOf(false)

    fun loginWithGoogle(launcher: ActivityResultLauncher<IntentSenderRequest>){
        repository.loginWithGoogle(launcher = launcher, loadingState = isLoading)
    }

    fun loginWithCredential(credential: AuthCredential) = repository.loginWithCredential(credential = credential)
}