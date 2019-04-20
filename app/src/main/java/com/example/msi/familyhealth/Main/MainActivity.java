package com.example.msi.familyhealth.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import com.example.msi.familyhealth.CheckData.CheckDataActivity;
import com.example.msi.familyhealth.Clock.ClockActivity;
import com.example.msi.familyhealth.HealthTips.HealthTipsActivity;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.MyData.MyDataActivity;
import com.example.msi.familyhealth.Position.PositonActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.Set.SetActivity;
import com.example.msi.familyhealth.View.ExitApplication;

public class MainActivity extends BaseActivity<MainContacts.IMainPresenter> implements MainContacts.IMainView {
    private ConstraintLayout mHealthDataCl;
    private ConstraintLayout mClockCl;
    private ConstraintLayout mHealthTipsCl;
    private ConstraintLayout mPositionCl;
    private ConstraintLayout mCallCl;
    private ConstraintLayout mSetCl;
    private Button mCheckDataBt;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExitApplication.getInstance().addActivity(this);

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
        mCheckDataBt = (Button) findViewById(R.id.main_bottom_bt);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("紧急拨号");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().call(MainActivity.this);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("点错了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

                showToast("紧急call");
            }
        });

        mSetCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(SetActivity.class);
            }
        });

        mCheckDataBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(CheckDataActivity.class);
            }
        });

    }

    private void jump(Class target) {
        showToast("click jump to" + target.getName().toString());
        intent.setClass(MainActivity.this, target);
        startActivity(intent);
    }
}
