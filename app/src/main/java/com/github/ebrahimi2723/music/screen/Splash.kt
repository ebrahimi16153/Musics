package com.github.ebrahimi2723.music.screen

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.github.ebrahimi2723.music.color.setColor
import com.github.ebrahimi2723.music.navigation.ScreensName
import com.github.ebrahimi2723.music.viewmodel.PermissionViewModel
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Splash(navController: NavController) {




        Surface(modifier = Modifier.fillMaxSize(), color = setColor().background.value) {
         Column(
             modifier = Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {

             Text(text = "SPLASH", color = setColor().text.value)



            // permission
             val viewModel = viewModel<PermissionViewModel>()
             val dialogQueue = viewModel.visiblePermissionDialogQueue
             val audioPermissionResultLauncher = rememberLauncherForActivityResult(
                 contract = ActivityResultContracts.RequestPermission() ,
                 onResult = {isGranted ->
                     viewModel.onPermission(
                         permission = Manifest.permission.READ_MEDIA_AUDIO,
                         isGranted = isGranted
                     )
                 }
             )

             // load music list

            LaunchedEffect(key1 =true  ){
                audioPermissionResultLauncher.launch(Manifest.permission.READ_MEDIA_AUDIO)
                delay(3000)
                navController.popBackStack()
                navController.navigate(ScreensName.AllSONGS.name)



            }


         }
     }






}
