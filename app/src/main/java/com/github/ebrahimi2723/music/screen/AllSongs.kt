package com.github.ebrahimi2723.music.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.github.ebrahimi2723.music.color.setColor

@Composable
fun AllSongs(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = setColor().background.value) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // content here
        }
    }
}

//
////@Preview
//@Composable
//fun MusicList(
//    navController: NavController, list: List<Audio>
//) {
//
//
////    LazyColumn {
////        items(list) {
////            MusicRow(music = it)
////
////        }
////    }
//    val scroll = rememberScrollState()
//    Column(modifier =  Modifier.verticalScroll(scroll)) {
//
//        for (i in list){
//            MusicRow(music = i)
//        }
//    }
//
//
//}
//
//@Composable
//fun MusicRow(music: Audio) {
//    Card(
//        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
//        contentColor = setColor().onPrimary.value, backgroundColor = setColor().primary.value
//    ) {
//
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.Start,
//            verticalArrangement = Arrangement.Center
//        ) {
//
//            Text(text = music.title)
//            Text(text = music.artist)
//            Text(text = music.DisplayName)
//
//        }
//
//    }
//}