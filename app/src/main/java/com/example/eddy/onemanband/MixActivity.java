package com.example.eddy.onemanband;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MixActivity extends NavActivity {
    ImageButton item1btn;
    ArrayList<File>songs;
    MediaPlayer mp1;
    int fromItem,position;
    TextView item1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_mix,null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mDrawerLayout.addView(contentView,0);

        item1=(TextView) findViewById(R.id.item1);
        if(getIntent()!=null){
            selectedSong();
        }

        item1btn=(ImageButton)findViewById(R.id.item1btn);
        item1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMusicListActivity=new Intent(getApplicationContext(),MusicListActivity.class).putExtra("item",1);
                startActivity(goToMusicListActivity);
            }
        });

    }

    protected  void selectedSong(){

        Intent i=getIntent();
        Bundle b=i.getExtras();
        songs=(ArrayList) b.getParcelableArrayList("songList");
        position=b.getInt("pos",0);
        fromItem=b.getInt("item",0);

        switch (fromItem){
            case 1:
                item1.setText(songs.get(position).getName().toString());
                break;
        }
    }



}
