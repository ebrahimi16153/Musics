package com.github.ebrahimi2723.music.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.ebrahimi2723.music.color.setColor
import com.github.ebrahimi2723.music.navigation.MyBottomAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Albums(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = setColor().background.value) {
        Scaffold(bottomBar = { MyBottomAppBar(navController = navController) }) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // content here
                Text(text = "Albums", color = setColor().text.value)

            }
        }
    }
}