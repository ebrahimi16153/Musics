package com.github.ebrahimi2723.music.util

import android.media.MediaPlayer
import com.github.ebrahimi2723.music.model.MusicFile

class Player {
    companion object{
        var mediaPlayer: MediaPlayer = MediaPlayer()
        var musicList:List<MusicFile> = ArrayList()
        var position:Int = 0
        var musicCount:Int = 0
    }

}