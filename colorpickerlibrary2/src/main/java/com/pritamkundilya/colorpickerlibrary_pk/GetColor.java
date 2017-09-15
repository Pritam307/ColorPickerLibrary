package com.pritamkundilya.colorpickerlibrary_pk;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;

/**
 * Created by Pritam on 9/13/2017.
 */

public class GetColor {

    Context context;
    ColorPickerView view;
    ColorAlpha alpha;
    Bitmap bitmap;
    int a=255,r,g,b;
    private static final String TAG="LIB";
    public GetColor(Context context,ColorPickerView view,ColorAlpha alpha) {
        this.context = context;
        this.view=view;
        this.alpha=alpha;
        bitmap = Bitmap.createBitmap(((BitmapDrawable) view.getDrawable()).getBitmap());
    }

    public int getPixel(MotionEvent event)
    {
        Matrix inverse=new Matrix();
        (view.getImageMatrix()).invert(inverse);
        float[] touchpoints=new float[]{event.getX(),event.getY()};
        inverse.mapPoints(touchpoints);
        int x= (int) touchpoints[0];
        int y= (int) touchpoints[1];
        int pixel=bitmap.getPixel(x,y);
        return pixel;
    }


    public void extract()
    {
        view.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    r= Color.red(getPixel(motionEvent));
                    g=Color.green(getPixel(motionEvent));
                    b=Color.blue(getPixel(motionEvent));
                    Log.d(TAG, "onTouch: " + r+"," +g+"," +","+ b);
                }
                alpha.setBackgroundTintList(ColorStateList.valueOf(Color.argb(a,r,g,b)));
                alpha.setProgress(255);
                return true;
            }
        });

        alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                a=i;
                alpha.getBackground().setAlpha(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                alpha.getBackground().setAlpha(255);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public ArrayList<Integer> getRGB()
    {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(a);
        arr.add(r);
        arr.add(g);
        arr.add(b);
        return arr;
    }

}
