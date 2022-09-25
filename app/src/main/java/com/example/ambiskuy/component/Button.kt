package com.example.ambiskuy.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonColors: AppButtonColors = AppButtonColors(Color.Blue, Color.Black, Color.Unspecified),
    shape: Shape = RoundedCornerShape(4.dp),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(shape)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = buttonColors.rippleColor, bounded = true)
            )
            .background(buttonColors.backgroundColor)
            .border(color = buttonColors.borderColor, width = 1.dp, shape = shape),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

data class AppButtonColors(
    val backgroundColor: Color,
    val rippleColor: Color,
    val borderColor: Color
)