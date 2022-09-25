package com.example.ambiskuy.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppNormalInputField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    placeHolderText: String,
    textStyle: TextStyle = TextStyle(fontSize = 12.sp),
    height: Dp = 42.dp,
    valueState: MutableState<String>,
    onValueChange: (String) -> Unit,
    inputFieldColor: InputFieldColor = InputFieldColor(White, Black),
    landingItem: (@Composable () -> Unit)? = null,
    trailingItem: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    shape: Shape = RoundedCornerShape(4.dp)
) {
    BasicTextField(
        value = valueState.value,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        enabled = true,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        interactionSource = remember { MutableInteractionSource() },
        onValueChange = {
            valueState.value = it
            onValueChange(it)
        },
        decorationBox = { innerTextField ->
            Box(contentAlignment = Alignment.CenterEnd) {
                /*Background*/
                Box(
                    modifier = modifier
                        .clip(shape)
                        .background(color = inputFieldColor.background)
                        .border(width = 1.dp, color = inputFieldColor.border, shape = shape)
                        .height(height),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        //Landing
                        landingItem?.let {
                            it()
                        }

                        //Text
                        Box(contentAlignment = Alignment.CenterStart) {
                            if (valueState.value.isEmpty()) Text(
                                text = placeHolderText,
                                style = textStyle,
                                color = Gray
                            )

                            innerTextField()
                        }

                    }
                }

                /*Foreground*/
                trailingItem?.let {
                    Box(modifier = Modifier.padding(8.dp), contentAlignment = Alignment.Center) {
                        it()
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppPasswordInputField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    placeHolderText: String,
    textStyle: TextStyle = TextStyle(fontSize = 12.sp),
    height: Dp = 42.dp,
    valueState: MutableState<String>,
    onValueChange: (String) -> Unit,
    inputFieldColor: InputFieldColor = InputFieldColor(White, Black),
    landingItem: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    shape: Shape = RoundedCornerShape(4.dp)
) {
    val showPassword = remember { mutableStateOf(false) }

    val visualTransformation =
        if (showPassword.value) VisualTransformation.None
        else PasswordVisualTransformation()


    BasicTextField(
        value = valueState.value,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        enabled = true,
        maxLines = maxLines,
        visualTransformation = visualTransformation,
        interactionSource = remember { MutableInteractionSource() },
        onValueChange = {
            valueState.value = it
            onValueChange(it)
        },
        decorationBox = { innerTextField ->
            Box(contentAlignment = Alignment.CenterEnd) {
                /*Background*/
                Box(
                    modifier = modifier
                        .clip(shape)
//                        .background(color = inputFieldColor.background)
                        .border(width = 1.dp, color = inputFieldColor.border, shape = shape)
                        .height(height),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        //Landing
                        landingItem?.let {
                            it()
                        }

                        //Text
                        Box(contentAlignment = Alignment.CenterStart) {
                            if (valueState.value.isEmpty()) Text(
                                text = placeHolderText,
                                style = textStyle,
                                color = Gray
                            )

                            innerTextField()
                        }

                    }
                }

                /*Foreground (Eye Icon Here)*/
                Box(modifier = Modifier.padding(8.dp), contentAlignment = Alignment.Center) {
                    AnimatedContent(targetState = showPassword.value) { show ->
                        if (show) {
                            Icon(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .clickable {
                                        showPassword.value = !showPassword.value
                                    },
                                imageVector = Icons.Default.VisibilityOff,
                                contentDescription = "Visibility Off"
                            )
                        } else {
                            Icon(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .clickable {
                                        showPassword.value = !showPassword.value
                                    },
                                imageVector = Icons.Default.Visibility,
                                contentDescription = "Visibility On"
                            )
                        }
                    }
                }
            }
        }
    )
}

data class InputFieldColor(
    val background: Color,
    val border: Color
)