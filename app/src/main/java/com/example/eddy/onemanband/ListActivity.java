package com.example.eddy.onemanband;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ListActivity extends NavActivity {

    final Context context = this;
    ListView musicList;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        musicList = (ListView) findViewById(R.id.musicLV);
        showSong();
    }

    public ArrayList<File> findSongs(File root) {
        ArrayList<File> mp3s = new ArrayList<File>();
        File[] files = root.listFiles();
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) {
                mp3s.addAll(findSongs(singleFile));
            } else {
                if (singleFile.getName().endsWith(".3gp") || singleFile.getName().endsWith(".txt") || singleFile.getName().endsWith(".mp3")) {
                    mp3s.add(singleFile);
                }
            }
        }

        return mp3s;
    }

    public void showSong() {
        String durationStr;
        long minutes,seconds,duration;
        MediaMetadataRetriever mmr=new MediaMetadataRetriever();
        String root = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Onemanband";
        ArrayList<File> songs = findSongs(new File(root));
        items = new String[songs.size()];
        for (int i = 0; i < songs.size(); i++) {
            mmr.setDataSource(songs.get(i).getPath());
            durationStr=mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            duration=Long.parseLong(durationStr);
            minutes= TimeUnit.MILLISECONDS.toMinutes(duration);
            seconds=TimeUnit.MILLISECONDS.toSeconds(duration);
            items[i] = songs.get(i).getName().toString()+"  Length: "+Long.toString(minutes)+":"+Long.toString(seconds);
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(getApplicationContext(), R.layout.song_layout, R.id.textView, items);
        musicList.setAdapter(adp);

    }
}
