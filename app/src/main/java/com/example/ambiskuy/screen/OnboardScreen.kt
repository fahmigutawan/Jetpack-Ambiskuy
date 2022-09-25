package com.example.ambiskuy.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ambiskuy.R
import com.example.ambiskuy.component.AppButton
import com.example.ambiskuy.helper.isLoggedIn
import com.example.ambiskuy.navigation.LandingNavigation
import com.example.ambiskuy.navigation.RootNavigation
import com.example.ambiskuy.viewmodel.OnboardViewModel

@Composable
fun OnboardScreen(rootNavController: NavController, landingNavController: NavController) {
    /**Attrs*/
    val viewModel = hiltViewModel<OnboardViewModel>()

    /**Function*/

    /**Content*/
    OnboardContent(
        rootNavController = rootNavController,
        landingNavController = landingNavController,
        viewModel = viewModel
    )
}

@Composable
private fun OnboardContent(
    rootNavController: NavController,
    landingNavController: NavController,
    viewModel: OnboardViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = R.drawable.ic_onboard,
                contentDescription = "Onboard Logo"
            )

            Column(
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Selamat datang di")

                Row {
                    Text(text = "ambis")
                    Text(text = "kuy", color = Color.Blue)
                    Text(text = "!")
                }
            }


            Text(
                text = "Aplikasi yang bakal bantuin kamu mencari " +
                        "dan berbagi materi UTBK. Susun jadwal " +
                        "belajar UTBK mu dan ngambis tanpa gangguan"
            )

            AppButton(onClick = {
                viewModel.saveFirstTimeOpenAppState(false)
                if(isLoggedIn()){
                    rootNavController.apply {
                        popBackStack()
                        navigate(route = RootNavigation.Content.name)
                    }
                }else{
                    landingNavController.apply {
                        popBackStack()
                        navigate(route = LandingNavigation.LoginScreen.name)
                    }
                }
            }) {
                Text(text = "Mulai")
            }
        }
    }
}