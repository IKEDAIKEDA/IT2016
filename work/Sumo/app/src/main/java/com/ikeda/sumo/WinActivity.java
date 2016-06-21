package com.ikeda.sumo;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class WinActivity extends Activity {
    MediaPlayer bgm;
    SoundPool se;
    int seStart;
    private boolean isBgm = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Viewのセット
//        LinearLayout l = new LinearLayout(this);
        setContentView(R.layout.activity_win);
//        setContentView(l);
//        l.addView(new WinView(this));
        //seの用意
//        SoundPool.Builder builder = new SoundPool.Builder();
//        se = builder.build();
//        seStart = se.load(this, R.raw.se_voice_low, 1);

//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//        }
        //bgm再生
        bgm = MediaPlayer.create(getApplicationContext(),(R.raw.bgm_win));
        //連続再生
//        bgm.setLooping(false);
        //再生
//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//        }
        bgm.start();
//        bgm.setVolume(1F, 1F);
//        bgm.release();
//        bgm = null;
//        try{
//            Thread.sleep(3000);
//        }catch(InterruptedException e){
//        }
        isBgm = false;
    }

    public void goNext(View view){
        if (isBgm == true){
            return;
        } else {
            //メニュ画面へ遷移
            Intent intent = new Intent(this, KawaigariActivity.class);
            startActivity(intent);

        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (bgm != null){
            bgm.release();
            bgm = null;
        }
    }
}
