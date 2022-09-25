package com.example.ambiskuy.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ambiskuy.component.AppButton
import com.example.ambiskuy.component.AppNormalInputField
import com.example.ambiskuy.component.AppPasswordInputField
import com.example.ambiskuy.viewmodel.LoginViewModel

@Composable
fun LoginScreen(rootNavController: NavController) {
    /**Attrs*/
    val viewModel = hiltViewModel<LoginViewModel>()

    /**Function*/

    /**Content*/
    LoginContent(viewModel = viewModel, rootNavController = rootNavController)
}

@Composable
private fun LoginContent(rootNavController: NavController, viewModel: LoginViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*Spacer*/
            item {
                Spacer(modifier = Modifier.height(84.dp))
            }

            /*Ambiskuy*/
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Ambis", fontSize = 32.sp)
                        Text(text = "Kuy", color = Color.Blue, fontSize = 32.sp)
                        Text(text = "!", fontSize = 32.sp)
                    }

                    Text(
                        text = "Tempat berbagi dan mencari materi UTBK tanpa gangguan",
                        textAlign = TextAlign.Center
                    )
                }
            }

            /*Email*/
            item {
                AppNormalInputField(
                    placeHolderText = "Masukkan Email Anda",
                    valueState = viewModel.emailState,
                    onValueChange = { /*TODO*/ }
                )
            }

            /*Password*/
            item {
                AppPasswordInputField(
                    placeHolderText = "Masukkan Password Anda",
                    valueState = viewModel.passwordState,
                    onValueChange = { /*TODO*/ })
            }

            /*Masuk Button*/
            item {
                AppButton(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
                    Text(text = "Masuk", color = Color.White)
                }
            }

            /*Lupa Kata Sandi*/
            item {
                Text(modifier = Modifier.clickable { /*TODO*/ }, text = "Lupa kata sandi?")
            }

            /*Divier*/
            item {
                Box(contentAlignment = Alignment.Center) {
                    Divider(
                        color = Color.Gray, modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                    )

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.background(Color.White)
                    ) {
                        Text(modifier = Modifier.padding(start = 16.dp, end = 16.dp), text = "Atau")
                    }
                }
            }

            /*Login dengan Google*/
            item {
                Row(modifier = Modifier.clickable { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.padding(end = 16.dp),
                        imageVector = Icons.Default.Circle,
                        contentDescription = "Google Dummy"
                    )
                    Text(text = "Lanjutkan dengan Google")
                }
            }
        }

        Row(
            modifier = Modifier.padding(bottom = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Belum punya akun? ")
            Text(modifier = Modifier.clickable { /*TODO*/ }, text = "Daftar", color = Color.Blue)
        }
    }


}