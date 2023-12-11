package com.github.ebrahimi2723.music

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import com.github.ebrahimi2723.music.navigation.MusicNavigation
import com.github.ebrahimi2723.music.ui.theme.MusicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()

           }
        }
    }


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MyApp() {
    MusicTheme {
      MusicNavigation()




        }
    }
