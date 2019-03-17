package com.example.msi.familyhealth.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.msi.familyhealth.Clock.ClockActivity;
import com.example.msi.familyhealth.HealthTips.HealthTipsActivity;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.MyData.MyDataActivity;
import com.example.msi.familyhealth.Position.PositonActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.Set.SetActivity;

public class MainActivity extends BaseActivity<MainContacts.IMainPresenter> implements MainContacts.IMainView {
    private ConstraintLayout mHealthDataCl;
    private ConstraintLayout mClockCl;
    private ConstraintLayout mHealthTipsCl;
    private ConstraintLayout mPositionCl;
    private ConstraintLayout mCallCl;
    private ConstraintLayout mSetCl;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        addListener();

    }

    @Override
    public MainContacts.IMainPresenter onBindPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void initView() {
        mHealthDataCl = (ConstraintLayout) findViewById(R.id.constraintLayout);
        mClockCl = (ConstraintLayout) findViewById(R.id.constraintLayout2);
        mHealthTipsCl = (ConstraintLayout) findViewById(R.id.constraintLayout3);
        mPositionCl = (ConstraintLayout) findViewById(R.id.constraintLayout4);
        mCallCl = (ConstraintLayout) findViewById(R.id.constraintLayout5);
        mSetCl = (ConstraintLayout) findViewById(R.id.constraintLayout6);
        intent = new Intent();
    }

    @Override
    public void addListener() {
        mHealthDataCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(MyDataActivity.class);
            }
        });

        mClockCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(ClockActivity.class);
            }
        });

        mHealthTipsCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(HealthTipsActivity.class);
            }
        });

        mPositionCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(PositonActivity.class);
            }
        });

        mCallCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("紧急call");
            }
        });

        mSetCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(SetActivity.class);
            }
        });

    }

    private void jump(Class target){
        showToast("click jump to"+target.getName().toString());
        intent.setClass(MainActivity.this,target);
        startActivity(intent);
    }
}
