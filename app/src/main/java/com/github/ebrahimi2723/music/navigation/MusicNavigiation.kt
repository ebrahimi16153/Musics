package com.github.ebrahimi2723.music.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.ebrahimi2723.music.R
import com.github.ebrahimi2723.music.color.setColor
import com.github.ebrahimi2723.music.screen.Splash

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicNavigation() {

    val navController = rememberNavController()


    Scaffold(bottomBar = {}) {

        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = ScreensName.SPLASH.name
        ) {

            //splash
            composable(ScreensName.SPLASH.name) {
                Splash(navController = navController)
            }


        }
    }


}

//@Composable
//fun MyBottomAppBar(navController: NavController){
//
//    BottomAppBar() {
//       BottomNavigationItem(selected = false, onClick = { /*TODO*/ }) {
//          Icon(imagr, contentDescription = )
//
//       }
//
//    }
//
//}