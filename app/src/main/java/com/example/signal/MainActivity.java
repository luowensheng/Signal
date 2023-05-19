package com.example.signal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.signal.imageProcessing.Drawer;
import com.example.signal.imageProcessing.RGBAColor;

import java.io.IOException;
import java.io.InputStream;
//import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        setContentView(R.layout.main_layout);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus) return;

        ImageView imageView = (ImageView) findViewById(R.id.image);
        InputStream ims = null;
        try {


            ims = getAssets().open("messi.jpeg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Drawable d = Drawable.createFromStream(ims, null);
//        imageView.setImageDrawable(d);
//
        Drawer drawer = Drawer.createDrawer(imageView);

//        Drawer drawer = Drawer.fromImageStream(imageView, ims);
        drawer.loadImageStream(ims);
//        drawer.drawText("So, it works huh", 100, 300, 20, Color.BLUE);
        for (int i = 0; i < drawer.getWidth()/2; i++) {
            for (int j = 0; j < drawer.getHeight()/2; j++) {
                RGBAColor color = drawer.getPixelRGBA(i, j);
//                Log.d("debug", color.toString());
                if (true){
                    drawer.setPixel(i, j, Color.rgb(i%255, (i+j)%255, j%255));
                }
            }
        }

//        String text =  String.format("(width=%d, height %d)", drawer.getWidth(), drawer.getHeight());

//        drawer.drawText(text, 100, 100, 20, Color.BLACK);
        drawer.drawText("So, it works huh", 100, 300, 20, Color.BLUE);
        drawer.drawText("So, it works huh", 100, 200, 20, Color.BLUE);
//        drawer.drawLine(30, 40, 100, 100, Color.RED, 10);

    }

}
