package com.github.ebrahimi2723.music

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.ebrahimi2723.music.navigation.MusicNavigation
import com.github.ebrahimi2723.music.ui.theme.MusicTheme
import com.github.ebrahimi2723.music.viewmodel.PermissionViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel = viewModel<PermissionViewModel>()
            val dialogQueue = viewModel.visiblePermissionDialogQueue
            val adiuoPermissionResultLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission() ,
                onResult = {isGranted ->
                    viewModel.onPermission(
                        permission = Manifest.permission.READ_MEDIA_AUDIO,
                        isGranted = isGranted
                    )
                }
            )




           MyApp()
               
           }
        }
    }


@Composable
fun MyApp() {
    MusicTheme {
        // A surface container using the 'background' color from the theme
          MusicNavigation()

        }
    }
