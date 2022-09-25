package com.example.ambiskuy.navigation_host

import android.os.Bundle
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ambiskuy.component.AppBottomMenu
import com.example.ambiskuy.helper.BottomMenuItem
import com.example.ambiskuy.navigation.ContentNavigationMain
import com.example.ambiskuy.viewmodel.ContentViewModel

@Composable
fun ContentNavhost(
    rootNavController: NavHostController,
    contentNavController: NavHostController
) {
    /**Attrs*/
    val bottomMenuVisibleState = remember { mutableStateOf(true) }
    val contentViewModel = hiltViewModel<ContentViewModel>()

    /**Function*/
    contentNavController.addOnDestinationChangedListener { _, destination, _ ->
        when(destination.route){
            ContentNavigationMain.HomeScreen.name -> {
                contentViewModel.bottomBarState.value = BottomMenuItem.HomeScreen
                bottomMenuVisibleState.value = true
            }
            ContentNavigationMain.StudyTogetherScreen.name -> {
                contentViewModel.bottomBarState.value = BottomMenuItem.StudyTogetherScreen
                bottomMenuVisibleState.value = true
            }
            ContentNavigationMain.ShareScreen.name -> {
                contentViewModel.bottomBarState.value = BottomMenuItem.ShareScreen
                bottomMenuVisibleState.value = true
            }
            ContentNavigationMain.SavedScreen.name -> {
                contentViewModel.bottomBarState.value = BottomMenuItem.SavedScreen
                bottomMenuVisibleState.value = true
            }
            else -> bottomMenuVisibleState.value = false
        }
    }

    /**Content*/
    ContentNavhostContent(
        rootNavController = rootNavController,
        contentNavController = contentNavController,
        bottomMenuVisibleState = bottomMenuVisibleState,
        contentViewModel = contentViewModel
    )
}

@Composable
private fun ContentNavhostContent(
    contentViewModel: ContentViewModel,
    rootNavController: NavHostController,
    contentNavController: NavHostController,
    bottomMenuVisibleState: MutableState<Boolean>
) {
    Scaffold(bottomBar = {
        if (bottomMenuVisibleState.value) AppBottomMenu(
            contentNavController = contentNavController,
            contentViewModel = contentViewModel
        )
    }) {
        NavHost(
            navController = contentNavController,
            startDestination = ContentNavigationMain.HomeScreen.name
        ) {
            composable(ContentNavigationMain.HomeScreen.name) {
            }

            composable(ContentNavigationMain.StudyTogetherScreen.name) {

            }

            composable(ContentNavigationMain.ShareScreen.name) {

            }

            composable(ContentNavigationMain.SavedScreen.name) {

            }
        }
    }
}