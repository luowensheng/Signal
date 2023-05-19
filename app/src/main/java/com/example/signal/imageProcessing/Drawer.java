package com.example.signal.imageProcessing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.ColorInt;

import java.io.InputStream;


public class Drawer extends Canvas {
    private ImageView imageView;
    private Bitmap bitmap;
    public static Drawer createDrawer(ImageView imageView){
        Bitmap bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
//        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        imageView.setImageBitmap(bitmap);
        return new Drawer(imageView, bitmap);
    }

    public static Drawer fromImageStream(ImageView imageView, InputStream imageStream){
        Bitmap bitmap = BitmapFactory.decodeStream(imageStream).copy(Bitmap.Config.ARGB_8888, true);
        imageView.setImageBitmap(bitmap);
        return new Drawer(imageView, bitmap);
    }

    public static Drawer createDrawer(ImageView imageView, int width, int height){
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        imageView.setImageBitmap(bitmap);
        return new Drawer(imageView, bitmap);
    }

    public Drawer(ImageView imageView, Bitmap bitmap){
        super(bitmap);
        this.imageView = imageView;
//        this.bitmap = bitmap;
        this.bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        imageView.setImageBitmap(bitmap);
    }

    public void loadImageStream(InputStream imageStream) {
       Bitmap _bitmap = Bitmap.createScaledBitmap(
               BitmapFactory
                       .decodeStream(imageStream)
                       .copy(Bitmap.Config.ARGB_8888, false)
               , bitmap.getWidth(), bitmap.getHeight(), false);

        for (int i = 0; i < bitmap.getWidth(); i++) {
            for (int j = 0; j < bitmap.getHeight(); j++) {
                setPixel(i, j, _bitmap.getPixel(i, j));
            }
        }
    }

    public void drawLine(float startX, float startY, float stopX, float stopY){
        drawLine(startX, startY, stopX, stopY, Color.BLACK);
    }

    public RGBAColor getPixelRGBA(int x, int y){
        return new RGBAColor(bitmap.getPixel(x, y));
    }

    public int getPixel(int x, int y){
        return bitmap.getPixel(x, y);
    }

    public void setPixel(int x, int y, @ColorInt int color){
         bitmap.setPixel(x, y, color);
    }

    public void drawLine(float startX, float startY, float stopX, float stopY, int color){
        drawLine(startX, startY, stopX, stopY, color, 1);
    }

    public void drawLine(float startX, float startY, float stopX, float stopY, int color, int thickness){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStrokeWidth(thickness);
        drawLine(startX, startY, stopX, stopY, paint);
    }

    public void drawCircle(float cx, float cy, int radius){
        drawCircle(cx, cy, radius, Color.BLACK);
    }
    public void drawCircle(float cx, float cy, int radius, int color){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        drawCircle(cx, cy, radius, paint);
    }
    public void drawText(String text, float x, float y, float textSize, int color){
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.LEFT);
        drawText(text, x, y, paint);
    }
}
