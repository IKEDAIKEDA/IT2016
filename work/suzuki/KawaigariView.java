package com.ikeda.sumo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by admin on 16/06/20.
 */
public class KawaigariView extends View {
    Paint paint = new Paint();
    public String touchEvent = "heyamon";
    //画像読み込み
    Resources res = getContext().getResources();
    Bitmap dispBack = BitmapFactory.decodeResource(res, R.drawable.heyamon);
    Bitmap reDispBack;
    Bitmap bitmap;
    Bitmap reDispMe;
    Bitmap dispBack2 = BitmapFactory.decodeResource(res, R.drawable.keikobeya);
    Bitmap dispSenpai = BitmapFactory.decodeResource(res,R.drawable.senpai);
    Bitmap dispSenpai2 = BitmapFactory.decodeResource(res, R.drawable.senpai_2);
    Bitmap dispSenpaiUp1 = BitmapFactory.decodeResource(res,R.drawable.senpai_up1);
    Bitmap dispSenpaiUp2 = BitmapFactory.decodeResource(res,R.drawable.senpai_up2);
    Bitmap dispMe  = BitmapFactory.decodeResource(res, R.drawable.char_main);
    Bitmap  dispSumoOfDeath = BitmapFactory.decodeResource(res, R.drawable.sumo_of_death);
    Bitmap dispSerihuAkuruhi = BitmapFactory.decodeResource(res,R.drawable.serihu_akurihi);
    Bitmap dispSerihuSenpai1 = BitmapFactory.decodeResource(res,R.drawable.serihu_senpai1);
    Bitmap dispSerihuSenpai2 = BitmapFactory.decodeResource(res,R.drawable.serihu_senpai2);

    MediaPlayer bgm = MediaPlayer.create(getContext(), R.raw.bgm_honda);
//    SoundPool se;
//    int seStart;

    //先輩セリフ
    MediaPlayer seSenpaiSerihu = MediaPlayer.create(getContext(), R.raw.se_voice_low);
    //たたく１
    MediaPlayer seHit1 = MediaPlayer.create(getContext(), R.raw.se_1);
    //たたく2
    MediaPlayer seHit2 = MediaPlayer.create(getContext(), R.raw.se_2);
    //オーガズム
    MediaPlayer seCumShot = MediaPlayer.create(getContext(), R.raw.se_woww);
    MediaPlayer seDead = MediaPlayer.create(getContext(), R.raw.se_dead);

    private boolean isBgm = true;

    public KawaigariView(Context context){
        super(context);
    }

    //描画処理
    @Override
    public void onDraw(Canvas c){
        if(touchEvent.equals("heyamon")) {
            //相撲部屋の門
            //画面サイズ取得
            WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            //背景のリサイズ
            reDispBack = Bitmap.createScaledBitmap(dispBack,point.x,point.y,false);
            //部屋門を描画
            //bgm再生
            bgm.setLooping(true);
            bgm.start();
            c.drawBitmap(reDispBack, 0, 0, paint);
            c.drawBitmap(dispSerihuAkuruhi,0,700,paint);

        } else if( touchEvent.equals("senpaiTalk1")){
            //前画面メモリ解放
            kaihou(reDispBack);
            kaihou(dispBack);

            //稽古部屋と先輩と私
            bgm.setVolume(0.4F, 0.4F);
            //画面サイズ取得
            WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            //背景のリサイズ
            reDispBack = Bitmap.createScaledBitmap(dispBack2,point.x,point.y,false);

            //稽古部屋と先輩を描画
            //先輩背景透明
            int width = dispSenpai.getWidth();
            int height = dispSenpai.getHeight();
            int[] pixels = new int[width * height];
            int intC = dispSenpai.getPixel(0, 0);
            // 0,0 のピクセルと同じ色のピクセルを透明化する．
            bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888 );
            dispSenpai.getPixels(pixels, 0, width, 0, 0, width, height);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if( pixels[x + y * width]== intC){ pixels[x + y * width] = 0; }
                }
            }
            bitmap.eraseColor(Color.argb(0, 0, 0, 0));
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);


            c.drawBitmap(reDispBack, 0, 0, paint);
            c.drawBitmap(bitmap, 650, 100, paint);
            //メインキャラリサイズ
            reDispMe = Bitmap.createScaledBitmap(dispMe,(point.x/3),(point.y/2),false);
            c.drawBitmap(reDispMe, 0, 150, paint);

            c.drawBitmap(dispSerihuSenpai1,0,700,paint);
            //セリフ
            seSenpaiSerihu.start();

        } else if( touchEvent.equals("senpaiTalk2")){
            //前画面メモリ解放
            kaihou(reDispBack);
            kaihou(dispBack2);
            kaihou(dispSenpai);
            kaihou(bitmap);
            kaihou(reDispBack);
            kaihou(reDispMe);
            kaihou(dispMe);
            kaihou(dispSerihuSenpai1);
            if(seSenpaiSerihu != null){
                seSenpaiSerihu.release();;
                seSenpaiSerihu = null;
            }

            //稽古部屋と先輩と私第２章
            //画面サイズ取得
            WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            //背景のリサイズ
            reDispBack = Bitmap.createScaledBitmap(dispBack2,point.x,point.y,false);
            //先輩近づく
            //先輩背景透明
            int width = dispSenpai.getWidth();
            int height = dispSenpai.getHeight();
            int[] pixels = new int[width * height];
            int intC = dispSenpai.getPixel(0, 0);
            // 0,0 のピクセルと同じ色のピクセルを透明化する．
            bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888 );
            dispSenpai.getPixels(pixels, 0, width, 0, 0, width, height);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if( pixels[x + y * width]== intC){ pixels[x + y * width] = 0; }
                }
            }
            bitmap.eraseColor(Color.argb(0, 0, 0, 0));
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

            c.drawBitmap(reDispBack, 0, 0, paint);
            c.drawBitmap(bitmap, 250,100,paint);
            //メインキャラリサイズ
            reDispMe = Bitmap.createScaledBitmap(dispMe,(point.x/4),(point.y/3),false);
            c.drawBitmap(reDispMe, 0, 150, paint);
            //セリフ
            c.drawBitmap(dispSerihuSenpai2,0,700,paint);
            seSenpaiSerihu.start();
        } else if( touchEvent.equals("death1")){
            //前画面解放
            kaihou(reDispBack);
            kaihou(dispBack2);
            kaihou(dispSenpai);
            kaihou(bitmap);
            kaihou(reDispMe);
            kaihou(dispMe);
            kaihou(dispSerihuSenpai2);
            if(seSenpaiSerihu != null){
                seSenpaiSerihu.release();;
                seSenpaiSerihu = null;
            }

            //先輩UP
            //先輩背景透明
            int width = dispSenpaiUp1.getWidth();
            int height = dispSenpaiUp1.getHeight();
            int[] pixels = new int[width * height];
            int intC = dispSenpaiUp1.getPixel(0, 0);
            // 0,0 のピクセルと同じ色のピクセルを透明化する．
            bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888 );
            dispSenpaiUp1.getPixels(pixels, 0, width, 0, 0, width, height);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if( pixels[x + y * width]== intC){ pixels[x + y * width] = 0; }
                }
            }
            bitmap.eraseColor(Color.argb(0, 0, 0, 0));
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

            c.drawColor(Color.BLACK);
            c.drawBitmap(bitmap, 300,100,paint);
        } else if( touchEvent.equals("death2")){
            //前画面解放
            kaihou(dispSenpaiUp1);
            kaihou(bitmap);

            //黒画面
            c.drawColor(Color.BLACK);
            seHit1.start();
        } else if( touchEvent.equals("death3")){
            if(seHit1 != null){
                seHit1.release();;
                seHit1 = null;
            }

            //先輩逆アップ
            c.drawColor(Color.BLACK);
            c.drawBitmap(dispSenpaiUp2, 300, 100, paint);
            seHit2.start();
        } else if( touchEvent.equals("death4")){
            kaihou(dispSenpaiUp2);
            if(seHit2 != null){
                seHit2.release();;
                seHit2 = null;
            }
            //黒画面
            c.drawColor(Color.BLACK);
            seCumShot.start();
        } else {
            if(seCumShot != null){
                seCumShot.release();;
                seCumShot = null;
            }
            //sumoOfDeath
            seDead.start();
            c.drawColor(Color.BLACK);
            c.drawBitmap(dispSumoOfDeath, 250, 100, paint);


        }

    }

    //画面タッチ
    public boolean onTouchEvent(MotionEvent me){
        if(me.getAction() == MotionEvent.ACTION_DOWN){
            if(touchEvent.equals("heyamon")){
                touchEvent = "senpaiTalk1";
                invalidate();
                return true;
            } else if( touchEvent.equals("senpaiTalk1")){
                touchEvent = "senpaiTalk2";
                invalidate();
                return true;

            } else if( touchEvent.equals("senpaiTalk2")){
                touchEvent = "death1";
                invalidate();
                return true;

            } else if( touchEvent.equals("death1")){
                touchEvent = "death2";
                invalidate();
                return true;
            } else if( touchEvent.equals("death2")){
                touchEvent = "death3";
                invalidate();
                return true;
            } else if( touchEvent.equals("death3")){
                touchEvent = "death4";
                invalidate();
                return true;

            } else {
                touchEvent = "sumoOfDeath";
                invalidate();
                return true;

            }
        }
        return true;
    }

    public void stopSound() {
        bgm.stop();
        if(bgm != null){
            bgm.release();
            bgm = null;
        }
        if(seSenpaiSerihu != null){
            seSenpaiSerihu.release();
            seSenpaiSerihu = null;
        }
        if(seHit1 != null){
            seHit1.release();
            seHit1 = null;
        }
        if(seHit2 != null){
            seHit2.release();
            seHit2 = null;
        }
        if(seCumShot != null){
            seCumShot.release();
            seCumShot = null;
        }
        if(seDead != null){
            seDead.release();
            seDead = null;
        }
    }

    private void kaihou(Bitmap bitmapTarget){
        if (bitmapTarget != null) {
            bitmapTarget.recycle();
            bitmapTarget = null;
        }
    }
}
