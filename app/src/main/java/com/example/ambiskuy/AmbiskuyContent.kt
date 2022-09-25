package com.example.ambiskuy

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.ambiskuy.navigation_host_root.RootNavhost

@Composable
fun AmbiskuyContent() {
    /**Attrs*/
    val rootNavController = rememberNavController()
    val landingNavController = rememberNavController()
    val contentNavController = rememberNavController()

    /**Function*/

    /**Content*/
    Surface(modifier = Modifier.fillMaxSize()) {
        RootNavhost(
            rootNavController = rootNavController,
            landingNavController = landingNavController,
            contentNavController = contentNavController
        )
    }
}