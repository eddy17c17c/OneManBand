package com.example.eddy.onemanband;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton guitarImageBtn=(ImageButton)findViewById(R.id.guitarImageBtn);
        ImageButton ringImageBtn=(ImageButton)findViewById(R.id.ringImageBtn);

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

    }
}
