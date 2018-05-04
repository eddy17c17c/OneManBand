package com.example.eddy.onemanband;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

public class Drum2Activity extends NavActivity {

    private SoundPool soundPool;
    int sound_C1,sound_C2,sound_C3,sound_C4,sound_Bass,sound_D1,sound_D2,sound_D3,sound_D4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_drum2,null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mDrawerLayout.addView(contentView,0);


        ImageButton playD1 = (ImageButton) this.findViewById(R.id.d1);
        ImageButton playD2 = (ImageButton) this.findViewById(R.id.d2);
        ImageButton playD3 = (ImageButton) this.findViewById(R.id.d3);
        ImageButton playD4 = (ImageButton) this.findViewById(R.id.d4);
        ImageButton playBass = (ImageButton) this.findViewById(R.id.bass);
        ImageButton playC1 = (ImageButton) this.findViewById(R.id.c1);
        ImageButton playC2 = (ImageButton) this.findViewById(R.id.c2);
        ImageButton playC3 = (ImageButton) this.findViewById(R.id.c3);
        ImageButton playC4 = (ImageButton) this.findViewById(R.id.c4);

        soundPool=new SoundPool.Builder().setMaxStreams(9).build();
        sound_C1=soundPool.load(this,R.raw.c1,1);
        sound_C2=soundPool.load(this,R.raw.c2,1);
        sound_C3=soundPool.load(this,R.raw.c3,1);
        sound_C4=soundPool.load(this,R.raw.c4,1);
        sound_Bass=soundPool.load(this,R.raw.bass,1);
        sound_D1=soundPool.load(this,R.raw.d1,1);
        sound_D2=soundPool.load(this,R.raw.d2,1);
        sound_D3=soundPool.load(this,R.raw.d3,1);
        sound_D4=soundPool.load(this,R.raw.d4,1);


    }
    public void playD1(View view){soundPool.play(sound_D1,1,1,1,0,1);}
    public void playD2(View view){soundPool.play(sound_D2,1,1,1,0,1);}
    public void playD3(View view){soundPool.play(sound_D3,1,1,1,0,1);}
    public void playD4(View view){soundPool.play(sound_D4,1,1,1,0,1);}
    public void playC1(View view){soundPool.play(sound_C1,1,1,1,0,1);}
    public void playC2(View view){soundPool.play(sound_C2,1,1,1,0,1);}
    public void playC3(View view){soundPool.play(sound_C3,1,1,1,0,1);}
    public void playC4(View view){soundPool.play(sound_C4,1,1,1,0,1);}
    public void playBass(View view){soundPool.play(sound_Bass,1,1,1,0,1);}
}
