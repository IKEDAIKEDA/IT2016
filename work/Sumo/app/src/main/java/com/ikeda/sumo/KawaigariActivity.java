package com.ikeda.sumo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class KawaigariActivity extends Activity {
    KawaigariView kwaigariView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_kawaigari);
        //Viewのセット
        RelativeLayout rl = new RelativeLayout(this);

//        LinearLayout l = new LinearLayout(this);
        setContentView(R.layout.activity_kawaigari);
        setContentView(rl);
        rl.addView(new KawaigariView(this));

//        TextView txtSerihu = new TextView(this);
//        String serihu1 = "あくる日・・・";
//        txtSerihu.setText(serihu1);
//        rl.addView(txtSerihu);

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        kwaigariView.stopSound();
    }

}
