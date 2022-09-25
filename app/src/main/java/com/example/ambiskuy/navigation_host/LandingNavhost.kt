package com.example.ambiskuy.navigation_host

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ambiskuy.navigation.LandingNavigation
import com.example.ambiskuy.screen.LoginScreen
import com.example.ambiskuy.screen.OnboardScreen
import com.example.ambiskuy.screen.SplashScreen

@Composable
fun LandingNavhost(
    rootNavController: NavHostController,
    landingNavController: NavHostController
) {
    /**Attrs*/

    /**Function*/

    /**Content*/
    LandingNavhostContent(
        rootNavController = rootNavController,
        landingNavController = landingNavController
    )
}

@Composable
private fun LandingNavhostContent(
    rootNavController: NavHostController,
    landingNavController: NavHostController
) {
    NavHost(
        navController = landingNavController,
        startDestination = LandingNavigation.SplashScreen.name
    ) {
        composable(route = LandingNavigation.SplashScreen.name) {
            SplashScreen(
                rootNavController = rootNavController,
                landingNavController = landingNavController
            )
        }

        composable(route = LandingNavigation.OnboardScreen.name) {
            OnboardScreen(
                rootNavController = rootNavController,
                landingNavController = landingNavController
            )
        }

        composable(route = LandingNavigation.LoginScreen.name){
            LoginScreen(rootNavController = rootNavController)
        }
    }
}