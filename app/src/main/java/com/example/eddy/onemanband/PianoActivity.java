package com.example.eddy.onemanband;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PianoActivity extends AppCompatActivity {

    MediaPlayer Do;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        Do=MediaPlayer.create(this,R.raw.ring);

    }

    public void playDo(View view){
        Do.start();
    }
}
