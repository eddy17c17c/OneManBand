package com.example.eddy.onemanband;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class PianoActivity extends NavActivity {

    private SoundPool soundPool;
    private int sound_Do,sound_Re,sound_Mi,sound_Fa,sound_So,sound_La,sound_Ti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instrumentType = 1;
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_piano,null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mDrawerLayout.addView(contentView,0);

        soundPool=new SoundPool.Builder().setMaxStreams(8).build();
        sound_Do=soundPool.load(this,R.raw.do111,1);
        sound_Re=soundPool.load(this,R.raw.re,1);
        sound_Mi=soundPool.load(this,R.raw.mi,1);
        sound_Fa=soundPool.load(this,R.raw.fa,1);
        sound_So=soundPool.load(this,R.raw.so,1);
        sound_La=soundPool.load(this,R.raw.la,1);
        sound_Ti=soundPool.load(this,R.raw.ti,1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.navigation_button,menu);
        return true;
    }

    public void playDo(View view){
        soundPool.play(sound_Do,1,1,1,0,1);
        Docheck=true;
    }
    public void playRe(View view){
        soundPool.play(sound_Re,1,1,1,0,1);
        Recheck=true;
    }
    public void playMi(View view){
        soundPool.play(sound_Mi,1,1,1,0,1);
        Micheck=true;
    }
    public void playFa(View view){
        soundPool.play(sound_Fa,1,1,1,0,1);
        Facheck=true;
    }
    public void playSo(View view){
        soundPool.play(sound_So,1,1,1,0,1);
        Socheck=true;
    }
    public void playLa(View view){
        soundPool.play(sound_La,1,1,1,0,1);
        Lacheck=true;
    }
    public void playTi(View view){
        soundPool.play(sound_Ti,1,1,1,0,1);
        Ticheck=true;
    }


}
