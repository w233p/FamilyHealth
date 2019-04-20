package com.example.msi.familyhealth.Position;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.ExitApplication;

public class PositonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExitApplication.getInstance().addActivity(this);

        setContentView(R.layout.positon_layout);
    }
}
