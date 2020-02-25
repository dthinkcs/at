package com.rishabhjaiswal.nirvananow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView video;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        video= findViewById(R.id.videoView);
        mc = new MediaController(this);
        mc.setAnchorView(video);
        video.setMediaController(mc);
        video.setKeepScreenOn(true);
        video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample);
        video.start();
        video.requestFocus();

    }
}