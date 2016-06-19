package com.ikeda.sumo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TorikumiActivity extends AppCompatActivity {
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torikumi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //試合画面のメインレイアウト生成
        RelativeLayout layoutShiai =(RelativeLayout)findViewById(R.id.layout_shiai);
        layoutShiai.setBackgroundResource(R.drawable.dohyou);

        //追加するキャライメージのパラメータ作成
        RelativeLayout.LayoutParams layoutParamCharactor = createParam(WC,WC);
        layoutParamCharactor.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        //キャラクタ表示用View生成
        ImageView charactorImage = new ImageView(this);
        charactorImage.setId('1');
        charactorImage.setImageResource(R.drawable.image_character);
        //Layoutへキャラ追加
        layoutShiai.addView(charactorImage,layoutParamCharactor);

        //追加する吹き出しのパラメータ作成
        RelativeLayout.LayoutParams layoutParamBalloon = createParam(WC,WC);
        layoutParamBalloon.addRule(RelativeLayout.RIGHT_OF,'1');

        //吹き出しView生成
        TextView balloon = new TextView(this);
        balloon.setPadding(80,70,80,20);
        balloon.setTextColor(Color.BLACK);
        balloon.setTextSize(18.0f);
        balloon.setBackgroundResource(R.drawable.balloon1);
        balloon.setText("今日は○○場所だ！\n頑張るぞ！！");
        //Layoutへ吹き出し追加
        layoutShiai.addView(balloon,layoutParamBalloon);


    }
    //RelativeLayout.LayoutParams 生成関数
    private RelativeLayout.LayoutParams createParam(int w, int h){
        return new RelativeLayout.LayoutParams(w, h);
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }

}
