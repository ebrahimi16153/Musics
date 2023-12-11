package com.github.ebrahimi2723.music.repository

import com.github.ebrahimi2723.music.data.ContentResolverHelper
import com.github.ebrahimi2723.music.data.model.Audio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AudioRepository @Inject constructor(private val contentResolverHelper: ContentResolverHelper) {

suspend fun getAudioData() :List<Audio> = withContext(Dispatchers.IO){

    contentResolverHelper.getAudioData()

}

}