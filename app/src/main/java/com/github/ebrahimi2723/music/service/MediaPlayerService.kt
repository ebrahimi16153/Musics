package com.github.ebrahimi2723.music.service

import android.media.browse.MediaBrowser
import android.os.Bundle
import android.service.media.MediaBrowserService
import com.github.ebrahimi2723.music.constants.MyConstant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MediaPlayerService : MediaBrowserService() {
    override fun onGetRoot(clintPackageName: String, clintUid: Int, rootHints: Bundle?): BrowserRoot {

       return BrowserRoot(MyConstant.MEDIA_ROOT_ID,null)

    }

    override fun onLoadChildren(parentId: String, p1: Result<MutableList<MediaBrowser.MediaItem>>) {
        TODO("Not yet implemented")
    }
}