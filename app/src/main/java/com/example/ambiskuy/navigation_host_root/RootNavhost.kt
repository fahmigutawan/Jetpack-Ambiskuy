package com.example.ambiskuy.navigation_host_root

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ambiskuy.navigation.RootNavigation
import com.example.ambiskuy.navigation_host.ContentNavhost
import com.example.ambiskuy.navigation_host.LandingNavhost

@Composable
fun RootNavhost(
    rootNavController: NavHostController,
    landingNavController: NavHostController,
    contentNavController: NavHostController
) {
    /**Attrs*/

    /**Function*/

    /**Content*/
    RootNavHostContent(
        rootNavController = rootNavController,
        landingNavController = landingNavController,
        contentNavController = contentNavController
    )
}

@Composable
private fun RootNavHostContent(
    rootNavController: NavHostController,
    landingNavController: NavHostController,
    contentNavController: NavHostController
) {
    NavHost(
        navController = rootNavController,
        startDestination = RootNavigation.Landing.name
    ) {
        composable(route = RootNavigation.Landing.name) {
            LandingNavhost(
                rootNavController = rootNavController,
                landingNavController = landingNavController
            )
        }

        composable(route = RootNavigation.Content.name) {
            ContentNavhost(
                rootNavController = rootNavController,
                contentNavController = contentNavController
            )
        }
    }
}