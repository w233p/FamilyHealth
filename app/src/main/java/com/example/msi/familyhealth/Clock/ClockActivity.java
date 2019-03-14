package com.example.msi.familyhealth.Clock;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.msi.familyhealth.R;

public class ClockActivity extends AppCompatActivity  {
    private Button addBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_add_layout);

//        /*设置Button的样式*/
//        addBt =(Button)findViewById(R.id.clock_add);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setCornerRadius(10);
//        gradientDrawable.setShape(GradientDrawable.OVAL);
//        gradientDrawable.setColor(getResources().getColor(R.color.loginYellow));
//        addBt.setBackground(gradientDrawable);
    }
}
