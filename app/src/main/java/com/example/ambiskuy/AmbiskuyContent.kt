package com.example.ambiskuy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.ambiskuy.navigation_host_root.RootNavhost

lateinit var appSnackbarListener: @Composable (String, MutableState<Boolean>) -> SnackbarData?

@Composable
fun AmbiskuyContent() {
    /**Attrs*/
    val rootNavController = rememberNavController()
    val landingNavController = rememberNavController()
    val contentNavController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    appSnackbarListener = { word, state ->
        val snackbarHostState = scaffoldState.snackbarHostState

        if (state.value) {
            LaunchedEffect(snackbarHostState) {
                val result = snackbarHostState.showSnackbar(
                    word,
                    duration = SnackbarDuration.Short,
                    actionLabel = "Close"
                )

                when (result) {
                    SnackbarResult.Dismissed -> state.value = false
                    SnackbarResult.ActionPerformed -> state.value = false
                }
            }
        }

        snackbarHostState.currentSnackbarData
    }

    /**Function*/

    /**Content*/
    Scaffold(scaffoldState = scaffoldState) {
        Surface(modifier = Modifier.fillMaxSize()) {
            RootNavhost(
                rootNavController = rootNavController,
                landingNavController = landingNavController,
                contentNavController = contentNavController
            )
        }
    }
}