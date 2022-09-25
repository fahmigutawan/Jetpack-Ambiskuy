package com.example.ambiskuy.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ambiskuy.R
import com.example.ambiskuy.helper.isLoggedIn
import com.example.ambiskuy.navigation.LandingNavigation
import com.example.ambiskuy.navigation.RootNavigation
import com.example.ambiskuy.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(rootNavController: NavController, landingNavController: NavController) {
    /**Attrs*/
    val delay = 2500L
    val viewModel = hiltViewModel<SplashViewModel>()

    /**Function*/
    LaunchedEffect(key1 = true) {
        delay(delay)

        viewModel.checkFirstTimeOpenAppState { firstTime ->
            if(firstTime){
                landingNavController.apply {
                    popBackStack(route = LandingNavigation.SplashScreen.name, inclusive = true)
                    navigate(route = LandingNavigation.OnboardScreen.name)
                }
            }else{
                if (isLoggedIn()) {
                    rootNavController.apply {
                        popBackStack(route = RootNavigation.Landing.name, inclusive = true)
                        navigate(route = RootNavigation.Content.name)
                    }
                } else {
                    landingNavController.apply {
                        popBackStack(route = LandingNavigation.SplashScreen.name, inclusive = true)
                        navigate(route = LandingNavigation.LoginScreen.name)
                    }
                }
            }
        }
    }

    /**Content*/
    SplashContent()
}

@Composable
private fun SplashContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.padding(64.dp),
            model = R.drawable.ic_logo,
            contentDescription = "Splash"
        )
    }
}