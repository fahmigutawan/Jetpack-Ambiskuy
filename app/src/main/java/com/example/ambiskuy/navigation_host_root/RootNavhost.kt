package com.example.ambiskuy.navigation_host_root

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.ambiskuy.navigation.RootNavigation

@Composable
fun RootNavhost() {
    /**Attrs*/
    val rootNavController = rememberNavController()

    /**Function*/

    /**Content*/
    RootNavHostContent(
        rootNavController = rootNavController
    )
}

@Composable
private fun RootNavHostContent(
    rootNavController: NavHostController
) {
    NavHost(
        navController = rootNavController,
        startDestination = RootNavigation.Landing.name) {

    }
}