package com.ikeda.sumo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by admin on 16/06/19.
 */
public class WinView extends View {
    Paint paint = new Paint();

    //画像読み込み
    Resources res = getContext().getResources();
    Bitmap dispBack = BitmapFactory.decodeResource(res, R.drawable.keikobeya);

    public WinView(Context context){
        super(context);
    }

    //描画処理
    @Override
    public void onDraw(Canvas c){
        c.drawBitmap(dispBack,1,1,paint);
    }
}
