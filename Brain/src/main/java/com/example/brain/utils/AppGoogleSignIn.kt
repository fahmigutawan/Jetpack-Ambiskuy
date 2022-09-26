package com.example.brain.utils

import android.content.Context
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.runtime.MutableState
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import javax.inject.Inject

class AppGoogleSignIn @Inject constructor(private val context: Context) {
    fun login(launcher: ActivityResultLauncher<IntentSenderRequest>, loadingState:MutableState<Boolean>) {
        loadingState.value = true

        val oneTapClient = Identity.getSignInClient(context)
        val googleSignInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId("252827846310-75m20tdr45811ste0kgldu962lts9n83.apps.googleusercontent.com")
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            )
            .build()

        oneTapClient.beginSignIn(googleSignInRequest)
            .addOnSuccessListener {
                val intentSenderRequest = IntentSenderRequest.Builder(it.pendingIntent).build()
                launcher.launch(intentSenderRequest)
            }.addOnFailureListener {
                /*Must handler this in the future*/
            }
    }
}