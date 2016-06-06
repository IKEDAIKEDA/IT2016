package com.example.admin.sumo_it;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.View;

/**
 * Created by admin on 16/06/05.
 */
public class TitleView extends View {
    public Long displaySizeX;
    public Long displaySizeY;
    public Long displayCenterX;
    public Long displayCenterY;


    Paint paint = new Paint();

    //画像読み込み
    Resources res = this.getContext().getResources();
    Bitmap titleBack = BitmapFactory.decodeResource(res, R.drawable.kokugikan);
    Bitmap titleCenter = BitmapFactory.decodeResource(res, R.drawable.chiyotaikai);

    public TitleView(Context context){
        super(context);
    }

    //描画処理
    @Override
    public void onDraw(Canvas c){
        c.drawBitmap(titleBack, 0, 0, paint);
        c.drawBitmap(titleCenter, 100, 100, paint);
    }

    //画面サイズ取得
    private void getDisplaySize(){

    }

    //コンテンツ領域とタイトルバーのサイズ
    public static Point getDisplaySize(Activity activity){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point;
    }

    //コンテンツ領域
    public static Point getViewSize(View view){
        Point point = new Point(0,0);
        point.set(view.getWidth(), view.getHeight());

        return point;
    }



}
