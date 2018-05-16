package com.example.eddy.onemanband;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MixActivity extends NavActivity {
    final Context context = this;
    ImageButton item1btn,item2btn;
    ArrayList<File>songs;
    MediaPlayer mp1;
    int fromItem,position;
    TextView item1,item2;
    Intent i;
    Bundle b;
    ListView musicList;
    String[]items;
    File selectedSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_mix,null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mDrawerLayout.addView(contentView,0);

        item1=(TextView) findViewById(R.id.item1);
        item2=(TextView)findViewById(R.id.item2);

        item1btn=(ImageButton)findViewById(R.id.item1btn);
        item2btn=(ImageButton)findViewById(R.id.item2btn);
        item1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li=LayoutInflater.from(context);
                View promptsView=li.inflate(R.layout.activity_music_list,null);

                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(context);

                musicList=(ListView)promptsView.findViewById(R.id.musiclist);
                String root= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Onemanband";
                final ArrayList<File> songs=findSongs(new File(root));
                items=new String[songs.size()];
                for(int i=0;i<songs.size();i++) {
                    items[i]=songs.get(i).getName().toString().replace(".mp3","");
                }

                ArrayAdapter<String> adp=new ArrayAdapter<String>(getApplicationContext(),R.layout.song_layout,R.id.textView,items);
                musicList.setAdapter(adp);

                musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        selectedSong=songs.get(position);
                    }
                });

                alertDialogBuilder.setView(promptsView);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                item1.setText(selectedSong.getName().toString());
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        item2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li=LayoutInflater.from(context);
                View promptsView=li.inflate(R.layout.activity_music_list,null);

                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(context);

                musicList=(ListView)promptsView.findViewById(R.id.musiclist);
                String root= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Onemanband";
                final ArrayList<File> songs=findSongs(new File(root));
                items=new String[songs.size()];
                for(int i=0;i<songs.size();i++) {
                    items[i]=songs.get(i).getName().toString().replace(".mp3","");
                }

                ArrayAdapter<String> adp=new ArrayAdapter<String>(getApplicationContext(),R.layout.song_layout,R.id.textView,items);
                musicList.setAdapter(adp);

                musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        selectedSong=songs.get(position);
                    }
                });

                alertDialogBuilder.setView(promptsView);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                item2.setText(selectedSong.getName().toString());
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();
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



/*
    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        i=getIntent();
        b=i.getExtras();

        try {
            if (b.containsKey("pos")) {
                selectedSong();
            }
        }catch (Exception e){

        }
    }

    protected  void selectedSong(){

        songs=(ArrayList) b.getParcelableArrayList("songList");
        position=b.getInt("pos",0);
        fromItem=b.getInt("item",0);



        switch (fromItem){
            case 1:
                item1.setText(songs.get(position).getName().toString());
                break;

            case 2:
                item2.setText(songs.get(position).getName().toString());
                break;
        }
    }
    */



}
