package com.example.brain.data.remote

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.runtime.MutableState
import com.example.brain.utils.AppGoogleSignIn
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val auth:FirebaseAuth,
    private val firestore:FirebaseFirestore,
    private val appGoogleSignIn: AppGoogleSignIn
){
    fun login(launcher: ActivityResultLauncher<IntentSenderRequest>, loadingState: MutableState<Boolean>){
        appGoogleSignIn.login(launcher = launcher, loadingState = loadingState)
    }

    fun loginWithCredential(credential: AuthCredential) = auth.signInWithCredential(credential)
}