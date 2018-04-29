package com.example.eddy.onemanband;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class RingActivity extends NavActivity {
    MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_ring,null);
        mDrawerLayout.addView(contentView,0);

       // setContentView(R.layout.activity_ring);


        ring=MediaPlayer.create(this,R.raw.ring);
    }

    public void playRing(View view){
         ring.start();
    }

}
