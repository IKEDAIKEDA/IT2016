package com.ikeda.sumo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySecond extends Activity {
    // イメージビュー
    private ImageView changeImageView;
    private ImageView changeImageViewRight;
    //　画像ID
    private int changeImageId;
    private int changeImageIdRight;
    /** スレッドUI操作用ハンドラ */
    private Handler mHandler = new Handler();
    /** テキストオブジェクト */
    private Runnable updateText;
    /** カウント用数値 */
    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_second);

        changeImageViewRight = (ImageView) findViewById(R.id.image_view_1);
        changeImageIdRight = R.drawable.saikoro3;
        changeImageViewRight.setImageResource(changeImageIdRight);

        changeImageView = (ImageView) findViewById(R.id.image_view_2);
        changeImageId = R.drawable.saikoro1;
        changeImageView.setImageResource(changeImageId);

        updateText = new Runnable() {
            public void run() {
//                TextView text = (TextView) findViewById(R.id.count);
//                count = Integer.valueOf(text.getText().toString());
                count += 1;
//                text.setText(count.toString());
                mHandler.removeCallbacks(updateText);
                mHandler.postDelayed(updateText, 100);

                switch (count) {
                    case 1:
                        changeImageIdRight = R.drawable.saikoro1;
                        changeImageId = R.drawable.saikoro2;
                        break;
                    case 4:
                        changeImageIdRight = R.drawable.saikoro_move1;
                        changeImageId = R.drawable.saikoro_move1;
                        break;
                    case 5:
                        changeImageIdRight = R.drawable.saikoro_move3;
                        changeImageId = R.drawable.saikoro_move2;
                        break;
                    case 6:
                        changeImageIdRight = R.drawable.saikoro_move4;
                        changeImageId = R.drawable.saikoro_move3;
                        break;
                    case 7:
                        changeImageIdRight = R.drawable.saikoro_move5;
                        changeImageId = R.drawable.saikoro_move4;
                        break;
                    case 8:
                        changeImageIdRight = R.drawable.saikoro1;
                        changeImageId = R.drawable.saikoro2;
                        break;
                    case 9:
                        changeImageIdRight = R.drawable.saikoro_move1;
                        changeImageId = R.drawable.saikoro_move1;
                        break;
                    case 10:
                        changeImageIdRight = R.drawable.saikoro_move3;
                        changeImageId = R.drawable.saikoro_move2;
                        break;
                    case 11:
                        changeImageIdRight = R.drawable.saikoro_move4;
                        changeImageId = R.drawable.saikoro_move3;
                        break;
                    case 12:
                        changeImageIdRight = R.drawable.saikoro_move5;
                        changeImageId = R.drawable.saikoro_move4;
                        break;
                    case 13:
                        changeImageIdRight = R.drawable.saikoro1;
                        changeImageId = R.drawable.saikoro2;
                        break;
                    case 14:
                        changeImageIdRight = R.drawable.saikoro_move1;
                        changeImageId = R.drawable.saikoro_move1;
                        break;
                    case 15:
                        changeImageIdRight = R.drawable.saikoro_move3;
                        changeImageId = R.drawable.saikoro_move2;
                        break;
                    case 16:
                        changeImageIdRight = R.drawable.saikoro_move4;
                        changeImageId = R.drawable.saikoro_move3;
                        break;
                    case 17:
                        changeImageIdRight = R.drawable.saikoro_move5;
                        changeImageId = R.drawable.saikoro_move4;
                        break;
                    case 18:
                        changeImageIdRight = R.drawable.saikoro_move4;
                        changeImageId = R.drawable.saikoro_move3;
                        break;
                    case 19:
                        changeImageIdRight = R.drawable.saikoro_move5;
                        changeImageId = R.drawable.saikoro_move4;
                        break;
                    case 20:
                        changeImageIdRight = R.drawable.saikoro6;
                        changeImageId = R.drawable.saikoro6;
                        break;
                    case 50:
                        // 画面遷移する。
                        Intent intent;
                        //インテントを作成し、遷移先のクラスを呼び出す。
                        intent = new Intent(ActivitySecond.this, ActivityThird.class);
                        startActivity(intent);
                        break;
                    default:
//                        changeImageIdRight = R.drawable.saikoro6;
//                        changeImageId = R.drawable.saikoro6;
                        break;
                }
                // 画像を変更
                changeImageView.setImageResource(changeImageId);
                changeImageViewRight.setImageResource(changeImageIdRight);
            }
        };
        mHandler.postDelayed(updateText, 100);
    }
}

