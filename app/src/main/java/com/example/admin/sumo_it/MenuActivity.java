package com.example.admin.sumo_it;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    MediaPlayer bgm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //bgmの再生
        bgm = MediaPlayer.create(getApplicationContext(),(R.raw.home_entrance));
        bgm.setLooping(true);;
        bgm.start();


    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        bgm.release();
        bgm = null;
    }
}
