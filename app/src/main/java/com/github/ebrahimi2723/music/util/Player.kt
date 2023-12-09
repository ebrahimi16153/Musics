package com.github.ebrahimi2723.music.util

import android.content.Context
import android.media.MediaPlayer
import android.provider.MediaStore
import com.github.ebrahimi2723.music.model.MusicFile

class Player {
    companion object{
        var mediaPlayer: MediaPlayer = MediaPlayer()
        var musicList:List<MusicFile> = ArrayList()
        var position:Int = 0
        var musicCount:Int = 0




        fun loadMusic(context: Context){
            // load all music list
            val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"

            val projection = arrayOf(

                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION,


                )

            val cursor = context.contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null
            )

            val songs = ArrayList<MusicFile>()
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    /*  StaticData.musicCount++ save  how many music is ArrayList - > int */


                    musicCount++
                    songs.add(

                        MusicFile(
                            cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),

                            )
                    )
                }
            }
            musicList = songs.sortedBy { it.title }
        }
    }

}


