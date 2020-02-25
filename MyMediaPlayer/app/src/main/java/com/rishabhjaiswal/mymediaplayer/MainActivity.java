package com.rishabhjaiswal.mymediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.faded);


    }

    public void pressPlay(View view) { // pressPlay -> playMusic like touchCard -> flipCard
        mp.start();
    }

    public void pressPause(View view) {
        mp.pause();
    }

    public void pressRewind(View view) {
        mp.seekTo(0);
    }

    public void pressForward(View view) {
//        int songDuration = mp.getDuration();
//        int futureTime = mp.getCurrentPosition() + 1000;
//        if (futureTime > songDuration) {
//            futureTime = songDuration;
//        }
        mp.seekTo(mp.getCurrentPosition() + 10000);
    }

    public void pressBack(View view) {
//        int pastTime = mp.getCurrentPosition() - 1000;
//        if (pastTime < 0) {
//            pastTime = 0;
//        }
        mp.seekTo(-10000);
    }
}
