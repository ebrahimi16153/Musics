package com.github.ebrahimi2723.music.data

import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.WorkerThread
import com.github.ebrahimi2723.music.data.model.Audio
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ContentResolverHelper @Inject constructor(@ApplicationContext val context: Context) {

    private var mCursor: Cursor? = null

    private val projection: Array<String> = arrayOf(
        MediaStore.Audio.AudioColumns.DISPLAY_NAME,
        MediaStore.Audio.AudioColumns._ID,
        MediaStore.Audio.AudioColumns.ARTIST,
        MediaStore.Audio.AudioColumns.DATA,
        MediaStore.Audio.AudioColumns.DURATION,
        MediaStore.Audio.AudioColumns.TITLE
    )

    private val selectionClause: String = "${MediaStore.Audio.AudioColumns.IS_MUSIC} = ?"
    private val selectionArg = arrayOf("1")
    private val sortOder = "${MediaStore.Audio.AudioColumns.DISPLAY_NAME} ASC"


    @WorkerThread
    fun getAudioData(): List<Audio> {

        return getCursor()
    }


    private fun getCursor(): MutableList<Audio> {

        val audioList = mutableListOf<Audio>()
        mCursor = context.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            selectionClause,
            selectionArg,
            sortOder
        )


        mCursor.use { cursor ->

            val idColumn = cursor?.getColumnIndex(MediaStore.Audio.AudioColumns._ID)
            val displayNameColumn =
                cursor?.getColumnIndex(MediaStore.Audio.AudioColumns.DISPLAY_NAME)
            val artistColumn = cursor?.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST)
            val dataColumn = cursor?.getColumnIndex(MediaStore.Audio.AudioColumns.DATA)
            val durationColumn = cursor?.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION)
            val titleColumn = cursor?.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE)


            cursor?.apply {

                if (count == 0) {

                    Log.e("Cursor", " getCursorData: Cursor is Empty")

                } else {
                    while (cursor.moveToNext()) {
                        val displayName = getString(displayNameColumn!!)
                        val id = getLong(idColumn!!)
                        val artists = getString(artistColumn!!)
                        val data = getString(dataColumn!!)
                        val duration = getInt(durationColumn!!)
                        val title = getString(titleColumn!!)
                        val uri = ContentUris.withAppendedId(
                            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                            id
                        )

                        audioList.add(Audio(uri, displayName, id, artists, data, duration, title))
                    }
                }


            }

        }

        return audioList

    }


}