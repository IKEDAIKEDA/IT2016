package com.ikeda.sumo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    // イメージビュー
    private ImageView changeImageView;
    private ImageView changeImageViewBack;
    //　画像ID
    private int changeImageId;
    private int changeImageBackId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //前に表示されている画像。
        changeImageView = (ImageView) findViewById(R.id.image_view_2);
        changeImageView.setOnClickListener(new ImageViewOnClick());
        changeImageId = R.drawable.sumo_1;
        changeImageView.setImageResource(changeImageId);
    }
    public class ImageViewOnClick implements OnClickListener {
        // クリックされたとき
        public void onClick(View args) {
            //画像を判定し、切り替える。
            switch (changeImageId) {
                case R.drawable.sumo_1:
                    changeImageId = R.drawable.sumo_2;
                case R.drawable.sumo_2:
                    // 画面遷移する。
                    Intent intent;
                    //インテントを作成し、遷移先のクラスを呼び出す。
                    intent = new Intent(MainActivity.this, ActivitySecond.class);
                    startActivity(intent);
                    break;
                default:
//                    changeImageId = R.drawable.sumo_1;
                    break;
            }
            // 画像を変更
            changeImageView.setImageResource(changeImageId);
        }
    }
}
