package com.github.ebrahimi2723.music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.github.ebrahimi2723.music.navigation.MusicNavigation
import com.github.ebrahimi2723.music.ui.theme.MusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyApp( )
        }
    }
}

@Composable
fun MyApp() {
    MusicTheme {
        // A surface container using the 'background' color from the theme
          MusicNavigation()

        }
    }
