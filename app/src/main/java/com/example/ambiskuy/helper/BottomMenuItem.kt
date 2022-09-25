package com.example.ambiskuy.helper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ambiskuy.navigation.ContentNavigationMain

enum class BottomMenuItem(val icon:ImageVector, val route:String) {
    HomeScreen(icon = Icons.Default.Home,route = ContentNavigationMain.HomeScreen.name),
    StudyTogetherScreen(icon = Icons.Default.Laptop,route = ContentNavigationMain.StudyTogetherScreen.name),
    ShareScreen(icon = Icons.Default.Share,route = ContentNavigationMain.ShareScreen.name),
    SavedScreen(icon = Icons.Default.Archive, route = ContentNavigationMain.SavedScreen.name)
}