package com.example.eddy.onemanband;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;

public class Drum2Activity extends NavActivity {

   // private SoundPool soundPool;
   // int sound_C1,sound_C2,sound_C3,sound_C4,sound_Bass,sound_D1,sound_D2,sound_D3,sound_D4;

    Boolean Basscheck=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instrumentType = 0;
        LayoutInflater inflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView=inflater.inflate(R.layout.activity_drum2,null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mDrawerLayout.addView(contentView,0);

        ImageButton playD1 = (ImageButton) this.findViewById(R.id.d1);
        ImageButton playD2 = (ImageButton) this.findViewById(R.id.d2);
        ImageButton playD3 = (ImageButton) this.findViewById(R.id.d3);
        ImageButton playD4 = (ImageButton) this.findViewById(R.id.d4);
        ImageButton playBass = (ImageButton) this.findViewById(R.id.bass);
        ImageButton playC1 = (ImageButton) this.findViewById(R.id.c1);
        ImageButton playC2 = (ImageButton) this.findViewById(R.id.c2);
        ImageButton playC3 = (ImageButton) this.findViewById(R.id.c3);
        ImageButton playC4 = (ImageButton) this.findViewById(R.id.c4);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.navigation_button,menu);
        return true;
    }


    public void playD1(View view){soundPool.play(sound_D1,1,1,1,0,1);
        D1check = true;
    }
    public void playD2(View view){soundPool.play(sound_D2,1,1,1,0,1);
        D2check = true;
    }
    public void playD3(View view){soundPool.play(sound_D3,1,1,1,0,1);
        D3check = true;
    }
    public void playD4(View view){soundPool.play(sound_D4,1,1,1,0,1);
        D4check = true;
    }

    public void playC1(View view){soundPool.play(sound_C1,1,1,1,0,1);
        C1check = true;
    }
    public void playC2(View view){soundPool.play(sound_C2,1,1,1,0,1);
        C2check = true;
    }
    public void playC3(View view){soundPool.play(sound_C3,1,1,1,0,1);
        C3check = true;
    }
    public void playC4(View view){soundPool.play(sound_C4,1,1,1,0,1);
        C4check = true;
    }
    public void playBass(View view){soundPool.play(sound_Bass,1,1,1,0,1);
        Basscheck = true;
    }
}
