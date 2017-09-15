package com.pritamkundilya.colorpickerlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.pritamkundilya.colorpickerlibrary_pk.ColorAlpha;
import com.pritamkundilya.colorpickerlibrary_pk.ColorPickerView;
import com.pritamkundilya.colorpickerlibrary_pk.GetColor;

import java.util.ArrayList;

import static com.pritamkundilya.colorpickerlibrary.R.id.mainLay;

public class MainActivity extends AppCompatActivity {
    GetColor color;
    ColorPickerView view;
    ColorAlpha seekbar;
    RelativeLayout lay;
    ArrayList<Integer> val=new ArrayList<>();
    private static final String TAG="LIB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lay=findViewById(mainLay);
        lay.getBackground().setAlpha(220);
        view= (ColorPickerView) findViewById(R.id.picker);
        seekbar= (ColorAlpha) findViewById(R.id.alphabar);

        color=new GetColor(getApplicationContext(),view,seekbar);
        color.extract();
    }

    public void onClickColor(View v)
    {
        val=color.getRGB();
        Toast.makeText(getApplicationContext(), "Alpha:"+val.get(0)+"Red:"+val.get(1)+"Green:"+val.get(2)+"Blue:"+val.get(3),Toast.LENGTH_LONG).show();
    }
}
