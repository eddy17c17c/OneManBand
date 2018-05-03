package com.example.eddy.onemanband;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class PianoActivity extends NavActivity {

    MediaPlayer Do,Re,Mi,Fa,So,La,Ti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_piano,null);
        mDrawerLayout.addView(contentView,0);

        Do=MediaPlayer.create(this,R.raw.do111);
        Re=MediaPlayer.create(this,R.raw.re);
        Mi=MediaPlayer.create(this,R.raw.mi);
        Fa=MediaPlayer.create(this,R.raw.fa);
        So=MediaPlayer.create(this,R.raw.so);
        La=MediaPlayer.create(this,R.raw.la);
        Ti=MediaPlayer.create(this,R.raw.ti);

    }

    public void playDo(View view){
        Do.start();
    }
    public void playRe(View view){
        Re.start();
    }
    public void playMi(View view){
        Mi.start();
    }
    public void playFa(View view){
        Fa.start();
    }
    public void playSo(View view){
        So.start();
    }
    public void playLa(View view){
        La.start();
    }
    public void playTi(View view){
        Ti.start();
    }


}
