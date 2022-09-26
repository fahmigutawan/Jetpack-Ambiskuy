package com.example.ambiskuy.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import com.example.ambiskuy.viewmodel.LoginViewModel
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun GoogleLoginLauncher(
    onSuccess: (AuthResult) -> Unit,
    onFailed: (Exception) -> Unit,
    context: Context,
    viewModel: LoginViewModel
) = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.StartIntentSenderForResult()
) { result ->
    val intent = result.data
    val oneTapClient = Identity.getSignInClient(context)

    when (result.resultCode) {
        Activity.RESULT_OK -> {
            val credential = oneTapClient.getSignInCredentialFromIntent(intent)

            if (credential.googleIdToken != null) {
                // Token retrieved
                val fbCredential = GoogleAuthProvider
                    .getCredential(credential.googleIdToken, null)

                viewModel.loginWithCredential(fbCredential)
                    .addOnSuccessListener {
                        onSuccess(it)
                    }
                    .addOnFailureListener {
                        onFailed(it)
                    }
            } else {
                // Token hasn't retrieved
                onFailed(Exception("Token has not retrieved"))
            }
        }
        else -> {
            if (result.data?.action == ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST) {
                // Couldn't start One Tap UI
                onFailed(Exception("Couldn't start One Tap Login"))
            }
        }
    }
}