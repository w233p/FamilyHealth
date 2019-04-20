package com.example.msi.familyhealth.HealthTips;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.ExitApplication;

public class HealthTipsActivity extends BaseActivity<HealthTipsContacts.IHealthTipPresenter> implements HealthTipsContacts.IHealthTipView {
    ListView tipListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExitApplication.getInstance().addActivity(this);

        setContentView(R.layout.healthtips_layout);

        initView();

        addListener();
    }

    @Override
    public HealthTipsContacts.IHealthTipPresenter onBindPresenter() {
        return new HealthTipsPresenter(this);
    }

    @Override
    public void initView() {
        tipListView = (ListView)findViewById(R.id.health_tip_listview);
        getPresenter().listSetAdapter(this,tipListView);
    }

    @Override
    public void addListener() {

    }
}
