package com.pritamkundilya.colorpickerlibrary_pk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by Pritam on 9/13/2017.
 */

public class ColorAlpha extends android.support.v7.widget.AppCompatSeekBar {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public ColorAlpha(Context context) {
        super(context);
        Drawable drawable=getResources().getDrawable(R.drawable.colordisplay);
        setForeground(drawable);

    }

    public ColorAlpha(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.colordisplay);
    }

    public ColorAlpha(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundResource(R.drawable.colordisplay);
    }


}
