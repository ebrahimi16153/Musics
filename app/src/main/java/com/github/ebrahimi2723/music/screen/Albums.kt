package com.github.ebrahimi2723.music.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.ebrahimi2723.music.color.setColor

@Composable
fun Albums(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize(), color = setColor().background.value) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Albums", color = setColor().text.value)

        }


    }
}