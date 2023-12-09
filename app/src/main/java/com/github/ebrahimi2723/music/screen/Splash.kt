package com.github.ebrahimi2723.music.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.ebrahimi2723.music.color.setColor
import com.github.ebrahimi2723.music.navigation.ScreensName
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavController) {




        Surface(modifier = Modifier.fillMaxSize(), color = setColor().background.value) {
         Column(
             modifier = Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {

             Text(text = "SPLASH", color = setColor().text.value)


            LaunchedEffect(key1 =true  ){
                 delay(3000)
                navController.popBackStack()
                navController.navigate(ScreensName.AllSONGS.name)



            }


         }
     }






}
