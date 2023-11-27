package com.github.ebrahimi2723.music.screen

import android.provider.MediaStore
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.github.ebrahimi2723.music.color.setColor
import com.github.ebrahimi2723.music.model.MusicFile
import com.github.ebrahimi2723.music.navigation.ScreensName
import com.github.ebrahimi2723.music.util.Player
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavController) {

     Surface(modifier = Modifier.fillMaxSize(), color = setColor().background.value) {
         Column(
             modifier = Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {


             // load all music list
             val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"

             val projection = arrayOf(

                 MediaStore.Audio.Media._ID,
                 MediaStore.Audio.Media.ARTIST,
                 MediaStore.Audio.Media.TITLE,
                 MediaStore.Audio.Media.DATA,
                 MediaStore.Audio.Media.DISPLAY_NAME,
                 MediaStore.Audio.Media.DURATION,


                 )

             val cursor = LocalContext.current.contentResolver.query(
                 MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                 projection,
                 selection,
                 null,
                 null
             )

             val songs = ArrayList<MusicFile>()
             if (cursor != null) {
                 while (cursor.moveToNext()) {
                     /*  StaticData.musicCount++ save  how many music is ArrayList - > int */


                     Player.musicCount++
                     songs.add(

                         MusicFile(
                             cursor.getString(0),
                             cursor.getString(1),
                             cursor.getString(2),
                             cursor.getString(3),
                             cursor.getString(4),
                             cursor.getString(5),

                             )
                     )
                 }
             }
             Player.musicList = songs.sortedBy { it.title }

             Text(text = "SPLASH", color = setColor().text.value)


            LaunchedEffect(key1 =true  ){
                 delay(3000)
                navController.popBackStack()
                navController.navigate(ScreensName.AllSONGS.name)



            }


         }
     }






}
