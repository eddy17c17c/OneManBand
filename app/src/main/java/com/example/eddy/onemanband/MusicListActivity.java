package com.example.eddy.onemanband;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;

public class MusicListActivity extends AppCompatActivity {

    ListView musicList;
    String [] items;
    int itemNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        musicList=(ListView)findViewById(R.id.musiclist);

        Intent j=getIntent();
        Bundle b=j.getExtras();
        itemNumber=b.getInt("item",0);

        String root=Environment.getExternalStorageDirectory().getAbsolutePath()+"/Onemanband";
        final ArrayList<File> songs=findSongs(new File(root));
        items=new String[songs.size()];
        for(int i=0;i<songs.size();i++) {
            items[i]=songs.get(i).getName().toString().replace(".mp3","");
        }

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.song_layout,R.id.textView,items);
        musicList.setAdapter(adp);
        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),MixActivity.class).putExtra("pos",position).putExtra("songList",songs).putExtra("item",itemNumber);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);

            }
        });

    }

    public ArrayList<File> findSongs(File root){
        ArrayList<File> mp3s=new ArrayList<File>();
        File[] files = root.listFiles();
        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                mp3s.addAll(findSongs(singleFile));
            }else{
                if(singleFile.getName().endsWith(".mp3")){
                    mp3s.add(singleFile);
                }
            }
        }

        return mp3s;
    }

    public void toast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

}
