package com.example.signal.imageProcessing;

import android.graphics.Color;

import androidx.annotation.ColorInt;

public class RGBAColor {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public RGBAColor(@ColorInt int color){
        red = Color.red(color);
        green = Color.green(color);
        blue = Color.blue(color);
        alpha = Color.alpha(color);
    }

    public int getAlpha() {
        return alpha;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

    public RGBAColor(int r, int g, int b){
        red = r;
        green = g;
        blue = b;
        alpha = 1;
    }

    public RGBAColor(int r, int g, int b, int a){
        red = r;
        green = g;
        blue = b;
        alpha = a;
    }

    public int toRGB(){
        return Color.argb(alpha, red, green, blue);
    }

    @Override
    public String toString(){
        return String.format("rgba(%d,%d,%d,%d)", red, green, blue, alpha);
    }

}
