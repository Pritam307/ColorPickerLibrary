package com.pritamkundilya.colorpickerlibrary_pk;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Pritam on 9/13/2017.
 */

public class ColorPickerView  extends android.support.v7.widget.AppCompatImageView{

    private static final String TAG="LIB";
    GetColor color;
    Context context;
    int pixel;
    public ColorPickerView(Context context) {
        super(context);
        this.context=context;
        setImageResource(R.drawable.color);
    }

    public ColorPickerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        setImageResource(R.drawable.color);
    }

    public ColorPickerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        setImageResource(R.drawable.color);
    }

}
