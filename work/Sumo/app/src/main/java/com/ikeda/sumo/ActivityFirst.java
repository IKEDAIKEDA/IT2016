package com.ikeda.sumo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ActivityFirst extends Activity {
    // イメージビュー
    private ImageView changeImageView;
    private ImageView changeImageViewBack;
    //　画像ID
    private int changeImageId;
    private int changeImageBackId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity.first);
        //前に表示されている画像。
//        changeImageView = (ImageView) findViewById(R.id.image_view_2);
//       changeImageView.setOnClickListener(new ImageViewOnClick());
//        changeImageId = R.drawable.sumo_1;
//        changeImageView.setImageResource(changeImageId);
    }
    public class ImageViewOnClick implements OnClickListener {
        // クリックされたとき
        public void onClick(View args) {
            //画像を判定し、切り替える。
//            switch (changeImageId) {
//                case R.drawable.sumo_1:
//                    changeImageId = R.drawable.sumo_2;
//                case R.drawable.sumo_2:
                    // 画面遷移する。
                    Intent intent;
                    //インテントを作成し、遷移先のクラスを呼び出す。
                    intent = new Intent(ActivityFirst.this, ActivitySecond.class);
//                    startActivity(intent);
//                    break;
//                default:
//                    changeImageId = R.drawable.sumo_1;
 //                   break;
            }
            // 画像を変更
 //           changeImageView.setImageResource(changeImageId);
//        }
    }
}
