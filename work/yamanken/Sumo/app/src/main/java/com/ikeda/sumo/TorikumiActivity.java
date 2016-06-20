package com.ikeda.sumo;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TorikumiActivity extends AppCompatActivity {
    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private static int TIMEOUT_MESSAGE = 1;
    private static int INTERVAL = 1;
    private TextView balloon;
    private ToneGenerator toneGenerator;
    private RelativeLayout layoutShiai;
    private ImageView charactorImage;

    String put_word = "";
    String put_text = "";
    String put_txt = "今日は○○場所だ！\n頑張るぞ！！";
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torikumi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //試合画面のメインレイアウト生成
        layoutShiai =(RelativeLayout)findViewById(R.id.layout_shiai);
        layoutShiai.setBackgroundResource(R.drawable.dohyou);

        //追加するキャライメージのパラメータ作成
        RelativeLayout.LayoutParams layoutParamCharactor = createParam(WC,WC);
        layoutParamCharactor.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        //キャラクタ表示用View生成
        charactorImage = new ImageView(this);
        charactorImage.setId('1');
        charactorImage.setImageResource(R.drawable.image_character);
        //Layoutへキャラ追加
        layoutShiai.addView(charactorImage,layoutParamCharactor);

        //追加する吹き出しのパラメータ作成
        RelativeLayout.LayoutParams layoutParamBalloon = createParam(WC,WC);
        layoutParamBalloon.addRule(RelativeLayout.RIGHT_OF,'1');

        //吹き出しView生成
        balloon = new TextView(this);
        balloon.setPadding(80,70,80,20);
        balloon.setTextColor(Color.BLACK);
        balloon.setTextSize(18.0f);
        balloon.setBackgroundResource(R.drawable.balloon1);
//?        balloon.setText("今日は○○場所だ！\n頑張るぞ！！");
        //Layoutへ吹き出し追加
        layoutShiai.addView(balloon,layoutParamBalloon);

        handler.sendEmptyMessage(TIMEOUT_MESSAGE);

    }
     // 文字列を一文字ずつ出力するハンドラ
     //処理の最後で画像切り替え
     private Handler handler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            // 文字列を配列に１文字ずつセット
            char data[] = put_txt.toCharArray();
            // 配列数を取得
            int arr_num = data.length;
            //ToneGenerator用意
            toneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, ToneGenerator.MAX_VOLUME);
            if (i < arr_num) {
                if (msg.what == TIMEOUT_MESSAGE) {
                    put_word = String.valueOf(data[i]);
                    put_text = put_text + put_word;
                    balloon.setText(put_text);
                    //Beep音鳴らす
                    toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP);
                    //handlerに0.6秒待たせる
                    handler.sendEmptyMessageDelayed(TIMEOUT_MESSAGE, INTERVAL * 100);
                    i++;
                } else {
                    super.dispatchMessage(msg);
                }
            } else if (i == arr_num) {
                if (msg.what == TIMEOUT_MESSAGE) {

                    sleep(1500);

                    layoutShiai.removeView(balloon);
                    layoutShiai.removeView(charactorImage);
                    ImageView torikumiHyo = new ImageView(TorikumiActivity.this);
                    torikumiHyo.setBackgroundResource(R.drawable.torikumi);
                    RelativeLayout.LayoutParams layoutParamTorikumihyo = createParam(WC, WC);
                    layoutParamTorikumihyo.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    torikumiHyo.setLayoutParams(layoutParamTorikumihyo);

                    layoutShiai.addView(torikumiHyo);
                    i++;
                } else {
                    super.dispatchMessage(msg);
                }
            }
        }
     };

    //指定ミリ秒実行を止めるメソッド
    public synchronized void sleep(long msec)
    {
        try
        {
            wait(msec);
        }catch(InterruptedException e){}
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
