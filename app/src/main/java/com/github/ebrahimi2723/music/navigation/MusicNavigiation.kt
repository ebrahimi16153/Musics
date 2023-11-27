package com.github.ebrahimi2723.music.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.ebrahimi2723.music.R
import com.github.ebrahimi2723.music.color.setColor
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