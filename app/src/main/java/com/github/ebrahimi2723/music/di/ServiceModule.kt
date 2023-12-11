package com.github.ebrahimi2723.music.di

//import com.google.android.exoplayer2.ExoPlayer
import android.content.Context
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped


@Module
@InstallIn(ServiceModule::class)
object ServiceModule {

    @Provides
    @ServiceScoped

    fun provideAudioAttributes(): AudioAttributes =
        AudioAttributes.Builder().setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
            .setUsage(C.USAGE_MEDIA).build()


    @Provides
    @ServiceScoped
    fun provideExoPlayer(
        @ApplicationContext context: Context, audioAttributes: AudioAttributes
    ):ExoPlayer = ExoPlayer.Builder(context).build().apply {
        setAudioAttributes(audioAttributes,true)
        setHandleAudioBecomingNoisy(true)
    }


}