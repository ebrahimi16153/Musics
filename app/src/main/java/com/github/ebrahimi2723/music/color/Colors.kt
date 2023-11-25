package com.github.ebrahimi2723.music.color

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

class MyColor(
    val background: MutableState<Color>,
    val primary:  MutableState<Color>,
    val text:  MutableState<Color>,
    val onBackground: MutableState<Color>,
    val onPrimary:  MutableState<Color>
)



// myColor
// light
val lightBackground = Color(0xFFDADEFF)
val lightText = Color(0xFF444655)
val lightOnBackground = Color(0xFFE9BBBE)
val lightPrimary = Color(0xFF007AFF)
val lightOnPrimary = Color(0xEFEFEFEF)



// myColor
// light
val darkBackground = Color(0xFF444655)
val darkText = Color(0XFFDADEFF)
val darkOnBackground = Color(0xFFA8AABC)
val darkPrimary = Color(0xFF007AFF)
val darkOnPrimary = Color(0xEFEFEFEF)


@Composable
fun setColor(dark:Boolean = isSystemInDarkTheme()):MyColor{

    return if (dark) {
        MyColor(background = remember{
            mutableStateOf(darkBackground)
        }, primary = remember {
            mutableStateOf(darkPrimary)
        }, text = remember{
            mutableStateOf(darkText)
        }, onBackground = remember {
            mutableStateOf(darkBackground)
        }, onPrimary = remember {
            mutableStateOf(darkOnPrimary)
        })
    }else{

        MyColor(background = remember{
            mutableStateOf(lightBackground)
        }, primary = remember {
            mutableStateOf(lightPrimary)
        }, text = remember{
            mutableStateOf(lightText)
        }, onBackground = remember {
            mutableStateOf(lightBackground)
        }, onPrimary = remember {
            mutableStateOf(lightOnPrimary)
        })

    }

}