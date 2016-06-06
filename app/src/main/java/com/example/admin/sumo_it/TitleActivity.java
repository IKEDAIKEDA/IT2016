package com.example.admin.sumo_it;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by admin on 16/06/05.
 */
public class TitleActivity extends Activity {

    MediaPlayer bgm;
//    MediaPlayer se;
    SoundPool se;
    int seStart;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //Viewのセット
//        LinearLayout l = new LinearLayout(this);
        setContentView(R.layout.main);

        //seの用意
        SoundPool.Builder builder = new SoundPool.Builder();
        se = builder.build();
        seStart = se.load(this, R.raw.ei_001, 1);

        //bgm再生
        bgm = MediaPlayer.create(getApplicationContext(),(R.raw.opening));
        //連続再生
        bgm.setLooping(true);
        //再生
        bgm.start();
        bgm.setVolume(0.5F, 0.5F);

//TitleViewの読み込み→使うのやめた        l.addView(new TitleView(this));
        //画像読み込み
//        Resources res = this.getResources();
//        Bitmap titleBack = BitmapFactory.decodeResource(res, R.drawable.kokugikan);
//        Bitmap titleCenter = BitmapFactory.decodeResource(res, R.drawable.chiyotaikai);
//
//        ImageView image1 = new ImageView(this);
//        image1.setImageBitmap(titleBack);
//        image1.setScaleType(ImageView.ScaleType.FIT_XY);

//        ImageView image2 = new ImageView(this);
//        image2.setImageBitmap(titleCenter);

//          l.addView(image1);
//        l.addView(image2);

    }


    public void goStart(View view){
        //画像の切り替え
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(R.drawable.kunio);
        //効果音再生
//        se = MediaPlayer.create(getApplicationContext(),(R.raw.ei_001));
//        se.start();
        se.play(seStart,1.0F,1.0F,0,0,1);
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
//            se.release();
//            se = null;
            //bgm終了
            bgm.release();
            bgm = null;
        }
//        se.release();
//        se = null;
        //bgm終了
        bgm.release();
        bgm = null;

        //メニュ画面へ遷移
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        se.release();
        se = null;
        bgm.release();
        bgm = null;


    }
}
