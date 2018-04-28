package com.example.eddy.onemanband;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RingActivity extends AppCompatActivity {
    MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);
        ring=MediaPlayer.create(this,R.raw.ring);
    }

    public void playRing(View view){
         ring.start();
    }

}
