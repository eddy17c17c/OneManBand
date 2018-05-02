package com.example.eddy.onemanband;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DrumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drum);

        final MediaPlayer getSoundC1 = MediaPlayer.create(this, R.raw.c1);
        final MediaPlayer getSoundC2 = MediaPlayer.create(this, R.raw.c2);
        final MediaPlayer getSoundC3 = MediaPlayer.create(this, R.raw.c3);
        final MediaPlayer getSoundC4 = MediaPlayer.create(this, R.raw.c4);
        final MediaPlayer getSoundBass = MediaPlayer.create(this, R.raw.bass);
        final MediaPlayer getSoundD1 = MediaPlayer.create(this, R.raw.d1);
        final MediaPlayer getSoundD2 = MediaPlayer.create(this, R.raw.d2);
        final MediaPlayer getSoundD3 = MediaPlayer.create(this, R.raw.d3);
        final MediaPlayer getSoundD4 = MediaPlayer.create(this, R.raw.d4);

        ImageButton playD1 = (ImageButton) this.findViewById(R.id.d1);
        ImageButton playD2 = (ImageButton) this.findViewById(R.id.d2);
        ImageButton playD3 = (ImageButton) this.findViewById(R.id.d3);
        ImageButton playD4 = (ImageButton) this.findViewById(R.id.d4);
        ImageButton playBass = (ImageButton) this.findViewById(R.id.bass);
        ImageButton playC1 = (ImageButton) this.findViewById(R.id.c1);
        ImageButton playC2 = (ImageButton) this.findViewById(R.id.c2);
        ImageButton playC3 = (ImageButton) this.findViewById(R.id.c3);
        ImageButton playC4 = (ImageButton) this.findViewById(R.id.c4);

        playD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundD1.start();
            }
        });
        playD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundD2.start();
            }
        });
        playD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundD3.start();
            }
        });
        playD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundD4.start();
            }
        });
        playBass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundBass.start();
            }
        });
        playC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundC1.start();
            }
        });
        playC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundC2.start();
            }
        });
        playC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundC3.start();
            }
        });
        playC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoundC4.start();
            }
        });
    }
}
