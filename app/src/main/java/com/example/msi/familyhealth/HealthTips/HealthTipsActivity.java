package com.example.msi.familyhealth.HealthTips;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.ExitApplication;
import com.example.msi.familyhealth.View.TitleView;

public class HealthTipsActivity extends BaseActivity<HealthTipsContacts.IHealthTipPresenter> implements HealthTipsContacts.IHealthTipView {
    private ListView tipListView;
    private TitleView tipTitleView;

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
        tipTitleView = (TitleView) findViewById(R.id.tip_titleView);
        tipListView = (ListView) findViewById(R.id.health_tip_listview);
        getPresenter().listSetAdapter(this, tipListView);
    }

    @Override
    public void addListener() {
        tipTitleView.setBackBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tipListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                getPresenter().
            }
        });
    }

    @Override
    public void showTipDialog() {

    }
}
