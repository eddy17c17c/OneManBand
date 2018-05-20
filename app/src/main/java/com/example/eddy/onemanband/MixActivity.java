package com.example.eddy.onemanband;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MixActivity extends NavActivity implements View.OnClickListener{
    final Context context = this;
    ImageButton item1btn,item2btn,item3btn;
    ArrayList<File>songs;
    int fromItem,position;
    TextView item1,item2,item3;
    Intent i;
    Bundle b;
    ListView musicList;
    String[]items;
    File selectedSong;
    MediaPlayer player1,player2,player3;
    Button playallbtn, play1btn,play2btn,play3btn;
    SeekBar sb1,sb2,sb3;
    Thread updateSeekBar1,updateSeekBar2,updateSeekBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_mix,null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mDrawerLayout.addView(contentView,0);

        if(player1!=null){
            player1.stop();
            player1.release();
        }

        if(player2!=null){
            player2.stop();
            player2.release();
        }

        if(player3!=null){
            player3.stop();
            player3.release();
        }

        play1btn=(Button) findViewById(R.id.play1btn) ;
        play2btn=(Button)findViewById(R.id.play2btn);
        play3btn=(Button)findViewById(R.id.play3btn);
        playallbtn=(Button) findViewById(R.id.playall);

        item1=(TextView) findViewById(R.id.item1);
        item2=(TextView)findViewById(R.id.item2);
        item3=(TextView)findViewById(R.id.item3);

        item1btn=(ImageButton)findViewById(R.id.item1btn);
        item2btn=(ImageButton)findViewById(R.id.item2btn);
        item3btn=(ImageButton)findViewById(R.id.item3btn);

        item1btn.setOnClickListener(this);
        item2btn.setOnClickListener(this);
        item3btn.setOnClickListener(this);
        play1btn.setOnClickListener(this);
        play2btn.setOnClickListener(this);
        play3btn.setOnClickListener(this);
        playallbtn.setOnClickListener(this);

        sb1=(SeekBar)findViewById(R.id.seekBar);
        sb2=(SeekBar)findViewById(R.id.seekBar2);
        sb3=(SeekBar)findViewById(R.id.seekBar3);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(seekBar.getProgress()==(player1.getDuration()-21)){
                    play1btn.setText(Html.fromHtml("&#9654;"));
                    seekBar.setProgress(0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player1.seekTo(seekBar.getProgress());
            }
        });
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(seekBar.getProgress()==(player2.getDuration()-21)){
                    play2btn.setText(Html.fromHtml("&#9654;"));
                    seekBar.setProgress(0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(seekBar.getProgress()==(player3.getDuration()-21)){
                    play3btn.setText(Html.fromHtml("&#9654;"));
                    seekBar.setProgress(0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
                if(singleFile.getName().endsWith(".3gp") || singleFile.getName().endsWith(".txt")||singleFile.getName().endsWith(".mp3")){
                    mp3s.add(singleFile);
                }
            }
        }

        return mp3s;
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

            case 3:item3.setText(songs.get(position).getName().toString());
                break;
        }
    }

    public void showSong(String s){
        final String temp=s;
        LayoutInflater li=LayoutInflater.from(context);
        View promptsView=li.inflate(R.layout.activity_music_list,null);

        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(context);

        musicList=(ListView)promptsView.findViewById(R.id.musiclist);
        String root= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Onemanband";
        final ArrayList<File> songs=findSongs(new File(root));
        items=new String[songs.size()];
        for(int i=0;i<songs.size();i++) {
            items[i]=songs.get(i).getName().toString().replace(".3gp","").replace(".mp3","").replace(".txt","(Score)");
        }

        ArrayAdapter<String> adp=new ArrayAdapter<String>(getApplicationContext(),R.layout.song_layout,R.id.textView,items);
        musicList.setAdapter(adp);

        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSong=songs.get(position);
                view.setSelected(true);
            }
        });

        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(temp.equals("item1")){
                            item1.setText(selectedSong.getName().toString().replace(".3gp","").replace(".mp3","").replace(".txt","(Score)"));

                            try {
                                if(player1!=null) {
                                    player1.stop();
                                    player1.release();
                                }

                                player1=new MediaPlayer();
                                player1.setDataSource(selectedSong.getPath());
                                player1.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else if(temp.equals("item2")){
                            item2.setText(selectedSong.getName().toString().replace(".3gp","").replace(".mp3","").replace(".txt","(Score)"));
                            player2=new MediaPlayer();
                            try {
                                player2.setDataSource(selectedSong.getPath());
                                player2.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else if(temp.equals("item3")){
                            item3.setText(selectedSong.getName().toString().replace(".3gp","").replace(".mp3","").replace(".txt","(Score)"));
                            player3=new MediaPlayer();
                            try {
                                player3.setDataSource(selectedSong.getPath());
                                player3.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

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

    @Override
    public void onClick(View v){
        int id=v.getId();
        switch (id){
            case R.id.item1btn:
                if(player1!=null)
                    player1.stop();
                showSong("item1");
                break;

            case R.id.item2btn:
                if(player2!=null)
                    player2.stop();
                showSong("item2");
                break;

            case R.id.item3btn:
                if(player3!=null)
                    player2.stop();
                showSong("item3");
                break;

            case R.id.play1btn:
                handlePlayer1();
                break;

            case R.id.play2btn:
                handlePlayer2();
                break;

            case R.id.play3btn:
                handlePlayer3();
                break;

            case R.id.playall:
                if(player1!=null)
                    handlePlayer1();
                if(player2!=null)
                    handlePlayer2();
                if(player3!=null)
                    handlePlayer3();
                break;
        }
    }

    public void handlePlayer1(){
        if(player1!=null) {
            if (player1.isPlaying()) {
                play1btn.setText(Html.fromHtml("&#9654;"));
                player1.pause();
            } else {
                play1btn.setText("||");
                player1.start();
            }


            if (sb1.getProgress()==0) {
                sb1.setMax(player1.getDuration()-21);
                updateSeekBar1=new Thread(){
                    @Override
                    public void run(){
                        int totalDuration=player1.getDuration();
                        int currentPosition=0;
                        while(totalDuration>(currentPosition+22)){
                            try {
                                sleep(500);
                                currentPosition=player1.getCurrentPosition();
                                sb1.setProgress(currentPosition);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                updateSeekBar1.start();
            }
        }
    }

    public void handlePlayer2(){
        if(player2!=null) {
            if (player2.isPlaying()) {
                play2btn.setText(Html.fromHtml("&#9654;"));
                player2.pause();
            } else {
                play2btn.setText("||");
                player2.start();
            }


            if (sb2.getProgress()==0) {
                sb2.setMax(player2.getDuration()-21);
                updateSeekBar2=new Thread(){
                    @Override
                    public void run(){
                        int totalDuration=player2.getDuration();
                        int currentPosition=0;
                        while(totalDuration>(currentPosition+22)){
                            try {
                                sleep(500);
                                currentPosition=player2.getCurrentPosition();
                                sb2.setProgress(currentPosition);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                updateSeekBar2.start();
            }
        }
    }

    public void handlePlayer3(){
        if(player3!=null) {
            if (player3.isPlaying()) {
                play3btn.setText(Html.fromHtml("&#9654;"));
                player3.pause();
            } else {
                play3btn.setText("||");
                player3.start();
            }


            if (sb3.getProgress()==0) {
                sb3.setMax(player3.getDuration()-21);
                updateSeekBar3=new Thread(){
                    @Override
                    public void run(){
                        int totalDuration=player3.getDuration();
                        int currentPosition=0;
                        while(totalDuration>(currentPosition+22)){
                            try {
                                sleep(500);
                                currentPosition=player3.getCurrentPosition();
                                sb3.setProgress(currentPosition);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                updateSeekBar3.start();
            }
        }
    }




}
