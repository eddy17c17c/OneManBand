package com.example.eddy.onemanband;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.media.MediaPlayer;
import android.media.MediaRecorder;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.support.v4.app.ActivityCompat;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class NavActivity extends AppCompatActivity {

    protected DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    protected Intent intent;

    Button buttonStart, buttonStop, buttonPlayLastRecordAudio,
            buttonStopPlayingRecording ;
    String AudioSavePathInDevice = null;
    String TxtSavePathInDevice = null;
    MediaRecorder mediaRecorder ;
    Random random ;
    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    public static final int RequestPermissionCode = 1;
    MediaPlayer mediaPlayer ;
    File oldFile;
    File latestname;
    private String result;
    final Context context = this;

    Boolean RecorderStatus = false;
    Boolean WriterStatus = false;

//Drum
    public Boolean D1check=false;
    public Boolean D2check=false;
    public Boolean D3check=false;
    public Boolean D4check=false;

    public Boolean C1check=false;
    public Boolean C2check=false;
    public Boolean C3check=false;
    public Boolean C4check=false;

    public Boolean Basscheck=false;

    public boolean writer;
    public ArrayList<String> tempArray = new ArrayList<String>();
    public int instrumentType;

//Piano do re mi fa so la Ti do

    public Boolean Docheck=false;
    public Boolean Recheck=false;
    public Boolean Micheck=false;
    public Boolean Facheck=false;
    public Boolean Socheck=false;
    public Boolean Lacheck=false;
    public Boolean Ticheck=false;

//Ring

    public Boolean Ringcheck=false;



    private void textWriter(String filename, int type){
        try {
            Log.d("Last","Starting writing");
            File file = new File(TxtSavePathInDevice);

            FileOutputStream fos = new FileOutputStream(file);

            if(type==0){
                fos.write("Drum \n".getBytes());
                //fos.write("Notes Count \n".getBytes());
                //fos.write(String.valueOf((tempArray.size())/9).getBytes());
            }
            if(type==1){
                fos.write("Piano \n".getBytes());
                //fos.write("Notes Count \n".getBytes());
                //fos.write(String.valueOf((tempArray.size())/7).getBytes());
            }
            if(type==2){
                fos.write("Ring \n".getBytes());
                //fos.write("Notes Count \n".getBytes());
                //fos.write(String.valueOf((tempArray.size())).getBytes());
            }
            fos.write(String.valueOf((tempArray.size())).getBytes());
            fos.write("\n".getBytes());
            for(int i=0;i<tempArray.size();i++){
                fos.write(tempArray.get(i).getBytes());
                if(tempArray.get(i).equals(" ")){
                    fos.write("\n".getBytes());
                }
            }
            fos.close();
            tempArray.clear();
           // Toast.makeText(getApplicationContext() , "Drum Scope Saved!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "File Not Found!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error saving", Toast.LENGTH_SHORT).show();
        }
    }

    private void textReader(final String filename){

    }

    private void drumpWriter(final String filename){
        final Handler handler = new Handler();
        Log.d("Second","Writer Check");
        handler.postDelayed(new Runnable(){
            public void run(){
                //do something
                if (D1check == true) {
                    //Log.d("D1","Third");
                    tempArray.add("1");
                    //Log.d("tempArraySize",String.valueOf(tempArray.size()));
                    D1check=false;
                } else {
                    tempArray.add("0");
                }
                if (D2check == true) {
                    tempArray.add("1");
                    D2check=false;
                } else {
                    tempArray.add("0");
                }
                if (D3check == true) {
                    tempArray.add("1");
                    D3check=false;
                } else {
                    tempArray.add("0");
                }
                if (D4check == true) {
                    tempArray.add("1");
                    D4check=false;
                } else {
                    tempArray.add("0");
                }
                if (C1check == true) {
                    tempArray.add("1");
                    C1check=false;
                } else {
                    tempArray.add("0");
                }
                if (C2check == true) {
                    tempArray.add("1");
                    C2check=false;
                } else {
                    tempArray.add("0");
                }
                if (C3check == true) {
                    tempArray.add("1");
                    C3check=false;
                } else {
                    tempArray.add("0");
                }
                if (C4check == true) {
                    tempArray.add("1");
                    C4check=false;
                } else {
                    tempArray.add("0");
                }
                tempArray.add(" ");

                if(writer==true) {
                    handler.postDelayed(this, 100);
                }
                if(writer==false){
                    textWriter(filename,0);
                }
            }
        }, 100);

        Log.d("tempArraySize", String.valueOf(tempArray.size()));
    }

    private void pianoWriter(final String filename){
        final Handler handler = new Handler();
        Log.d("Second","Writer Check");
        handler.postDelayed(new Runnable(){
            public void run(){
                //do something
                if (Docheck == true) {
                    //Log.d("D1","Third");
                    tempArray.add("1");
                    //Log.d("tempArraySize",String.valueOf(tempArray.size()));
                    Docheck=false;
                } else {
                    tempArray.add("0");
                }
                if (Recheck == true) {
                    tempArray.add("1");
                    Recheck=false;
                } else {
                    tempArray.add("0");
                }
                if (Micheck == true) {
                    tempArray.add("1");
                    Micheck=false;
                } else {
                    tempArray.add("0");
                }
                if (Facheck == true) {
                    tempArray.add("1");
                    Facheck=false;
                } else {
                    tempArray.add("0");
                }
                if (Socheck == true) {
                    tempArray.add("1");
                    Socheck=false;
                } else {
                    tempArray.add("0");
                }
                if (Lacheck == true) {
                    tempArray.add("1");
                    Lacheck=false;
                } else {
                    tempArray.add("0");
                }
                if (Ticheck == true) {
                    tempArray.add("1");
                    Ticheck=false;
                } else {
                    tempArray.add("0");
                }
                tempArray.add(" ");
                if(writer==true) {
                    handler.postDelayed(this, 100);
                }
                if(writer==false){
                    textWriter(filename,1);
                }
            }
        }, 100);

        Log.d("tempArraySize", String.valueOf(tempArray.size()));
    }

    private void ringWriter(final String filename){
        final Handler handler = new Handler();
        Log.d("Second","Writer Check");
        handler.postDelayed(new Runnable(){
            public void run(){
                //do something
                if (Ringcheck == true) {
                    //Log.d("D1","Third");
                    tempArray.add("1");
                    //Log.d("tempArraySize",String.valueOf(tempArray.size()));
                    Ringcheck=false;
                } else {
                    tempArray.add("0");
                }
                tempArray.add(" ");
                if(writer==true) {
                    handler.postDelayed(this, 100);
                }
                if(writer==false){
                    textWriter(filename,2);
                }
            }
        }, 100);

        Log.d("tempArraySize", String.valueOf(tempArray.size()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        mToolbar=(Toolbar)findViewById(R.id.nav_action);
       setSupportActionBar(mToolbar);

          //for nav menu
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //crete nav_open button

        //for nav_list buttons
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //set item as selected to persist highlight
                item.setChecked(true);
                //close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                switch (item.getItemId()){
                    case R.id.nav_home:
                        intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.nav_ring:
                        intent=new Intent(getApplicationContext(),RingActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.nav_piano:
                        intent=new Intent(getApplicationContext(),PianoActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_drum:
                        intent=new Intent(getApplicationContext(),Drum2Activity.class);
                        startActivity(intent);
                        return true;


                }
                return true;
            }
        });
    }

   //Enable click on nav button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        random = new Random();
        switch(item.getItemId()){
            case R.id.action_record:
                if(RecorderStatus==false){
                    RecorderStatus=true;
                    //to do
                    if(checkPermission()) {

                        AudioSavePathInDevice =
                                Environment.getExternalStorageDirectory().getAbsolutePath() + "/Onemanband"+"/" +
                                        CreateRandomAudioFileName(5) + "AudioRecording.3gp";

                        MediaRecorderReady();

                        try {
                            mediaRecorder.prepare();
                            mediaRecorder.start();
                        } catch (IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }


                        Toast.makeText(NavActivity.this, "Recording started",
                                Toast.LENGTH_LONG).show();
                    } else {
                        requestPermission();
                    }
                }


                return true;

            case R.id.action_play:
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(latestname.getPath());
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.start();
                Toast.makeText(NavActivity.this, "Recording Playing",
                        Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_stop:
                LayoutInflater li;
                View promptsView;
                if(RecorderStatus==true){
                    RecorderStatus=false;
                    mediaRecorder.stop();
                    // get prompts.xml view
                    li = LayoutInflater.from(context);
                    promptsView = li.inflate(R.layout.prompts, null);

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);
                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView(promptsView);
                    final EditText userInput = (EditText) promptsView
                            .findViewById(R.id.editTextDialogUserInput);
                    // set dialog message
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            // get user input and set it to result
                                            // edit text
                                            result = userInput.getText().toString();
                                            oldFile = new File(AudioSavePathInDevice);
                                            latestname = new File(Environment.getExternalStorageDirectory().getPath()+"/Onemanband/"+result+".3gp");
                                            boolean success = oldFile .renameTo(latestname );
                                        }
                                    });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();
                    Toast.makeText(NavActivity.this, "Recording Completed",
                            Toast.LENGTH_LONG).show();
                }
                if(WriterStatus==true){
                    WriterStatus=false;
                    writer=false;
                    // get prompts.xml view
                    li = LayoutInflater.from(context);
                    promptsView = li.inflate(R.layout.prompts, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);
                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView(promptsView);
                    final EditText userInput = (EditText) promptsView
                            .findViewById(R.id.editTextDialogUserInput);
                    // set dialog message
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            // get user input and set it to result
                                            // edit text
                                            result = userInput.getText().toString();
                                            oldFile = new File(TxtSavePathInDevice);
                                            latestname = new File(Environment.getExternalStorageDirectory().getPath()+"/Onemanband/"+result+".txt");
                                            boolean success = oldFile .renameTo(latestname );
                                        }
                                    });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();
                    Toast.makeText(NavActivity.this, "Writing Completed",
                            Toast.LENGTH_LONG).show();
                }
                return true;

            case R.id.action_writer:
                writer=true;
                if(WriterStatus==false){
                    WriterStatus=true;
                    if(checkPermission()) {
                        TxtSavePathInDevice =
                                Environment.getExternalStorageDirectory().getAbsolutePath() + "/Onemanband"+"/" +
                                        CreateRandomAudioFileName(5) + "TxtRecording.txt";
                        if(instrumentType==0){
                            drumpWriter(TxtSavePathInDevice);
                        }
                        if(instrumentType==1){
                            pianoWriter(TxtSavePathInDevice);
                        }
                        if(instrumentType==2){
                            ringWriter(TxtSavePathInDevice);
                        }
                    } else {
                        requestPermission();
                    }
                    Toast.makeText(NavActivity.this, "Writing started",
                            Toast.LENGTH_LONG).show();
                }

                return true;

        }

        return super.onOptionsItemSelected(item);
    }
    public void MediaRecorderReady(){
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(AudioSavePathInDevice);
    }

    public String CreateRandomAudioFileName(int string){
        StringBuilder stringBuilder = new StringBuilder( string );
        int i = 0 ;
        while(i < string ) {
            stringBuilder.append(RandomAudioFileName.
                    charAt(random.nextInt(RandomAudioFileName.length())));

            i++ ;
        }
        return stringBuilder.toString();
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(NavActivity.this, new
                String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length> 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(NavActivity.this, "Permission Granted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(NavActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),
                WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED;
    }
}
