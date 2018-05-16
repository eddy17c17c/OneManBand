package com.example.eddy.onemanband;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;

public class MainActivity extends NavActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_main,null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mDrawerLayout.addView(contentView,0);

        //for buttons
        ImageButton guitarImageBtn=(ImageButton)findViewById(R.id.guitarImageBtn);
        ImageButton ringImageBtn=(ImageButton)findViewById(R.id.ringImageBtn);
        ImageButton drumImageBtn=(ImageButton)findViewById(R.id.drumImageBtn);
        ImageButton pianoImageBtn=(ImageButton)findViewById(R.id.pianoImageBtn);
        ImageButton mixImageBtn=(ImageButton)findViewById(R.id.mixImageBtn);

        guitarImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToGuitarActivity=new Intent(getApplicationContext(),GuitarActivity.class);
                startActivity(goToGuitarActivity);
            }
        });

        ringImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRingActivity=new Intent(getApplicationContext(),RingActivity.class);
                startActivity(goToRingActivity);
            }
        });

        drumImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDrumActivity=new Intent(getApplicationContext(),Drum2Activity.class);
                startActivity(goToDrumActivity);
            }
        });

        pianoImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPianoActivity=new Intent(getApplicationContext(),PianoActivity.class);
                startActivity(goToPianoActivity);
            }
        });

        mixImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMixActivity=new Intent(getApplicationContext(),MixActivity.class);
                startActivity(goToMixActivity);
            }
        });

    }


}
