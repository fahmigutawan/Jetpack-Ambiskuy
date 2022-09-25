package com.example.ambiskuy.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ambiskuy.helper.BottomMenuItem
import com.example.ambiskuy.viewmodel.ContentViewModel

@Composable
fun AppBottomMenu(
    backgroundColor: Color = Color.White,
    contentNavController: NavController,
    contentViewModel: ContentViewModel
) {
    BottomAppBar(backgroundColor = backgroundColor) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomMenuItem.values().forEach { menu ->
                IconButton(onClick = { contentNavController.navigate(menu.route) }) {
                    Icon(
                        modifier = Modifier
                            .clip(CircleShape),
                        imageVector = menu.icon,
                        contentDescription = menu.name,
                        tint = if (contentViewModel.bottomBarState.value == menu) Color.Blue else Color.Gray
                    )
                }
            }
        }
    }
}