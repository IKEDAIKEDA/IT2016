package com.ikeda.sumo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TorikumiMenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torikumi_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnHitori = (Button)findViewById(R.id.btn_hitori);
        btnHitori.setOnClickListener(this);
        Button btnOnline = (Button)findViewById(R.id.btn_online);
        btnOnline.setOnClickListener(this);
        Button btnBack = (Button)findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,view.getTag().toString() ,Toast.LENGTH_SHORT).show();
        if(view.getId() == R.id.btn_hitori) {
            Intent intent = new Intent(TorikumiMenuActivity.this,TorikumiActivity.class);
            startActivity(intent);
        }

    }


    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }

}
