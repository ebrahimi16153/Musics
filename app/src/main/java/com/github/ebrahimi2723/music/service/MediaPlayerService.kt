package com.github.ebrahimi2723.music.service

import android.media.browse.MediaBrowser
import android.os.Bundle
import android.service.media.MediaBrowserService
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.exoplayer.ExoPlayer
import com.github.ebrahimi2723.music.constants.MyConstant
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MediaPlayerService : MediaBrowserService() {



    @Inject
    lateinit var  dataSourceFactory:CacheDataSource.Factory

    @Inject
    lateinit var exoPlayer: ExoPlayer

    override fun onGetRoot(clintPackageName: String, clintUid: Int, rootHints: Bundle?): BrowserRoot {

       return BrowserRoot(MyConstant.MEDIA_ROOT_ID,null)

    }

    override fun onLoadChildren(parentId: String, p1: Result<MutableList<MediaBrowser.MediaItem>>) {
        TODO("Not yet implemented")
    }
}