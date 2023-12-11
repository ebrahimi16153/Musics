package com.github.ebrahimi2723.music.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.ebrahimi2723.music.screen.Albums
import com.github.ebrahimi2723.music.screen.AllSongs
import com.github.ebrahimi2723.music.screen.Artist
import com.github.ebrahimi2723.music.screen.Splash

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MusicNavigation() {


    val navController = rememberNavController()


    Scaffold(bottomBar = { MyBottomAppBar(navController = navController) }) {
        Surface(modifier = Modifier.padding(it)) {


            NavHost(
                navController = navController,
                startDestination = ScreensName.SPLASH.name
            ) {


                // splash
                composable(ScreensName.SPLASH.name) {
                    Splash(navController = navController)
                }

                //AllSongs
                composable(ScreensName.AllSONGS.name) {
                    AllSongs(navController = navController)
                }

                // Albums
                composable(ScreensName.ALBUMS.name) {
                    Albums(navController = navController)
                }


                // Artists
                composable(ScreensName.ARTIST.name) {
                    Artist(navController = navController)
                }

            }
        }
    }
}