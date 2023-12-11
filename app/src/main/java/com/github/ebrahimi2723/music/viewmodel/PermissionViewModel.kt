package com.github.ebrahimi2723.music.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class PermissionViewModel : ViewModel() {

    val visiblePermissionDialogQueue = mutableStateListOf<String>()

    fun dismissDialog() {

        visiblePermissionDialogQueue.removeFirst()

    }


    fun onPermission(
        permission: String,
        isGranted: Boolean
    ) {
        if (isGranted) {
            visiblePermissionDialogQueue.add(0, permission)
        }


    }


}