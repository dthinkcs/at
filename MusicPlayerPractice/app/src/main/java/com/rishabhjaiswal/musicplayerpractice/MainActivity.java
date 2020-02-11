package com.rishabhjaiswal.musicplayerpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.faded);
    }


    public void playButtonPressed(View view) {
        mediaPlayer.start();
    }


    public void pauseButtonPressed(View view) {
        mediaPlayer.pause();
    }


    public void rewindButtonPressed(View view) {
        mediaPlayer.seekTo(0);
    }


    public void forwardButtonPressed(View view) {
        mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 10000);
    }


    public void playParticularSong(View view) {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.faded);
    }


}
