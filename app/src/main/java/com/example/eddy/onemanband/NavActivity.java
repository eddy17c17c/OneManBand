package com.example.eddy.onemanband;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.nio.channels.InterruptedByTimeoutException;

public class NavActivity extends AppCompatActivity {

    protected DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    protected Intent intent;

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
        return super.onOptionsItemSelected(item);
    }
}
