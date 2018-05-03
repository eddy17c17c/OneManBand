package com.example.eddy.onemanband;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Drum2Activity extends AppCompatActivity {
    MediaPlayer getSoundC1;
    MediaPlayer getSoundC2;
    MediaPlayer getSoundC3;
    MediaPlayer getSoundC4;
    MediaPlayer getSoundBass;
    MediaPlayer getSoundD1;
    MediaPlayer getSoundD2;
    MediaPlayer getSoundD3;
    MediaPlayer getSoundD4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drum2);

        getSoundC1 = MediaPlayer.create(this, R.raw.c1);
        getSoundC2 = MediaPlayer.create(this, R.raw.c2);
        getSoundC3 = MediaPlayer.create(this, R.raw.c3);
        getSoundC4 = MediaPlayer.create(this, R.raw.c4);
        getSoundBass = MediaPlayer.create(this, R.raw.bass);
        getSoundD1 = MediaPlayer.create(this, R.raw.d1);
        getSoundD2 = MediaPlayer.create(this, R.raw.d2);
        getSoundD3 = MediaPlayer.create(this, R.raw.d3);
        getSoundD4 = MediaPlayer.create(this, R.raw.d4);

        ImageButton playD1 = (ImageButton) this.findViewById(R.id.d1);
        ImageButton playD2 = (ImageButton) this.findViewById(R.id.d2);
        ImageButton playD3 = (ImageButton) this.findViewById(R.id.d3);
        ImageButton playD4 = (ImageButton) this.findViewById(R.id.d4);
        ImageButton playBass = (ImageButton) this.findViewById(R.id.bass);
        ImageButton playC1 = (ImageButton) this.findViewById(R.id.c1);
        ImageButton playC2 = (ImageButton) this.findViewById(R.id.c2);
        ImageButton playC3 = (ImageButton) this.findViewById(R.id.c3);
        ImageButton playC4 = (ImageButton) this.findViewById(R.id.c4);

    }
    public void playD1(View view){getSoundD1.start();}
    public void playD2(View view){getSoundD2.start();}
    public void playD3(View view){getSoundD3.start();}
    public void playD4(View view){getSoundD4.start();}
    public void playC1(View view){getSoundC1.start();}
    public void playC2(View view){getSoundC2.start();}
    public void playC3(View view){getSoundC3.start();}
    public void playC4(View view){getSoundC4.start();}
    public void playBass(View view){getSoundBass.start();}
}
