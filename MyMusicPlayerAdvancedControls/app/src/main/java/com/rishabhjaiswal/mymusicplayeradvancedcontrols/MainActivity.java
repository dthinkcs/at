package com.rishabhjaiswal.mymusicplayeradvancedcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button playButton; // toggle look of playButton

    SeekBar mSeekBar;
    TextView elapsedTimeLabel;
    TextView remainingTimeLabel;

    Handler mHandler;

    final int DELTA = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.f);
        playButton = findViewById(R.id.playButton);
        mHandler = new Handler();
        mHandler.postDelayed(updateSongTimings, 100);

        elapsedTimeLabel = findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel);
        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // int pos;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //pos = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

//                mp.seekTo( (int)((seekBar.getProgress()/100.0)*mp.getDuration()) ); // 100
//                Toast.makeText(getApplicationContext(), Integer.toString(seekBar.getProgress()), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo( (int)((seekBar.getProgress()/100.0)*mp.getDuration()) ); // 100
                //Toast.makeText(getApplicationContext(), Integer.toString(seekBar.getProgress()), Toast.LENGTH_SHORT).show();

            }
        });
    }

    Runnable updateSongTimings = new Runnable() {
        public void run() {
            int elapsedTime = mp.getCurrentPosition();
            int songDuration = mp.getDuration();
            elapsedTimeLabel.setText(String.format("%d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(elapsedTime),
                    TimeUnit.MILLISECONDS.toSeconds(elapsedTime) % 60));

            remainingTimeLabel.setText(String.format("%d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(songDuration),
                    TimeUnit.MILLISECONDS.toSeconds(songDuration) % 60));

            mSeekBar.setProgress((int)(100 * elapsedTime / (double)songDuration));
            if (!mp.isPlaying()) {
                playButton.setText(">");
            } else {
                playButton.setText("||");
            }
            mHandler.postDelayed(this,100);

        }
    };

    public void pressPlay(View view) {
        if (!mp.isPlaying()) {
            mp.start();
            playButton.setText(">");
        } else {
            mp.pause();
            playButton.setText("||");
        }
    }

    public void pressRewind(View v) {
        mp.seekTo(0);
    }

    public void pressForward(View v) {
        mp.seekTo(mp.getCurrentPosition() + DELTA);
    }

    public void pressBack(View v) {
        mp.seekTo(mp.getCurrentPosition() - DELTA);
    }



    // LABEL STUFF
    public void playBeliever(View v) {
        boolean wasPlaying = false; if (mp.isPlaying()) {wasPlaying = true;}
        if (mp != null) {
            mp.stop();
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(this, R.raw.b); if (wasPlaying == true) {mp.start();}
    }
    public void playFaded(View v) {
        // Toast.makeText(this, Boolean.toString(v.getId() == R.id.playFaded), Toast.LENGTH_SHORT).show();
        boolean wasPlaying = false; if (mp.isPlaying()) {wasPlaying = true;}

        if (mp != null) {
            mp.stop();
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(this, R.raw.f); if (wasPlaying == true) {mp.start();}
    }
    public void playStoneCold(View v) {
        boolean wasPlaying = false; if (mp.isPlaying()) {wasPlaying = true;}

        if (mp != null) {
            mp.stop();
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(this, R.raw.s); if (wasPlaying == true) {mp.start();}
    }


}
