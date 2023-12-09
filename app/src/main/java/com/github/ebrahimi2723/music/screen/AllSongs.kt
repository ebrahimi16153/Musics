package com.github.ebrahimi2723.music.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.ebrahimi2723.music.color.setColor
import com.github.ebrahimi2723.music.model.MusicFile
import com.github.ebrahimi2723.music.navigation.MyBottomAppBar
import com.github.ebrahimi2723.music.util.Player

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllSongs(navController: NavController) {
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
               MusicList(navController = navController, list = Player.musicList )
            }
        }
    }

}


//@Preview
@Composable
fun MusicList(
    navController: NavController, list: List<MusicFile>
) {


    LazyRow {
        items(list) {
            MusicRow(music = it)

        }
    }


}

@Composable
fun MusicRow(music: MusicFile) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        contentColor = setColor().onPrimary.value, backgroundColor = setColor().primary.value
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = music.title)
            Text(text = music.artist)
            Text(text = music.DisplayName)

        }

    }
}