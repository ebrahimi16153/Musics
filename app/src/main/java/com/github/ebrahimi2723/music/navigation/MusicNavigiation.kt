package com.github.ebrahimi2723.music.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.ebrahimi2723.music.screen.Albums
import com.github.ebrahimi2723.music.screen.AllSongs
import com.github.ebrahimi2723.music.screen.Artist
import com.github.ebrahimi2723.music.screen.Splash

@Composable
fun MusicNavigation() {


    val navController = rememberNavController()

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