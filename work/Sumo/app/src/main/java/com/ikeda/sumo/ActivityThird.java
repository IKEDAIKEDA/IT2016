package com.ikeda.sumo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by Yusuke on 2016/06/19.
 */
public class ActivityThird extends Activity {

    // イメージビュー
    private ImageView changeImageView;
    //　画像ID
    private int changeImageId;
    /** スレッドUI操作用ハンドラ */
    private Handler mHandler = new Handler();
    /** テキストオブジェクト */
    private Runnable updateText;
    /** カウント用数値 */
    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_third);
        changeImageView = (ImageView) findViewById(R.id.image_view_2);

        updateText = new Runnable() {
            public void run() {
                count += 1;
                mHandler.removeCallbacks(updateText);
                mHandler.postDelayed(updateText, 100);

                switch (count) {
                    case 50:
                        changeImageId = R.drawable.battle;
                        break;
                    case 80:
                        // 画面遷移する。
                        Intent intent;
                        //インテントを作成し、遷移先のクラスを呼び出す。
                        intent = new Intent(ActivityThird.this, WinActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                // 画像を変更
                changeImageView.setImageResource(changeImageId);
            }
        };
        mHandler.postDelayed(updateText, 100);
    }
}