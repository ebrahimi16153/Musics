package com.github.ebrahimi2723.music.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.ebrahimi2723.music.R

@Composable
fun MyBottomAppBar(navController: NavController) {

    val items = listOf("AllSongs", "Album", "Artists")
    var selectedItem by remember { mutableIntStateOf(0) }
    val icon = listOf(R.drawable.speaker, R.drawable.album, R.drawable.microphone)

    NavigationBar {

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = icon[index]),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.popBackStack()
                    navController.navigate(
                        if (index == 0) ScreensName.AllSONGS.name
                        else if (index == 1) ScreensName.ALBUMS.name
                        else ScreensName.ARTIST.name
                    )

                }
            )


        }
    }
}