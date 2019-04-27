package com.example.msi.familyhealth.CheckData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.CheckMarkView;
import com.example.msi.familyhealth.View.ExitApplication;
import com.example.msi.familyhealth.View.TitleView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;

public class CheckDataActivity extends BaseActivity<CheckDataContacts.ICheckDataPresenter> implements CheckDataContacts.ICheckDataView {

    private Spinner itemSp;
    private Spinner memberSp;
    private LineChart mLineChart;
    private int itemPositon;
    private int memberPositon;
    private CheckMarkView checkMarkView;
    private Button thisTimeBt;
    private Button weekBt;
    private Button monthBt;
    private Button yearBt;
    private TextView analysisText;
    private TitleView checkDataTitleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_chart);
        ExitApplication.getInstance().addActivity(this);

        initView();

        addListener();

    }

    @Override
    public CheckDataContacts.ICheckDataPresenter onBindPresenter() {
        return new CheckDataPresenter(this);
    }

    @Override
    public void initView() {
        itemSp = (Spinner) findViewById(R.id.checkdata_itemSp);
        memberSp = (Spinner) findViewById(R.id.checkdata_memberSp);
        thisTimeBt = (Button) findViewById(R.id.thistime_chart);
        weekBt = (Button) findViewById(R.id.week_chart);
        monthBt = (Button) findViewById(R.id.month_chart);
        yearBt = (Button) findViewById(R.id.year_chart);
        analysisText = (TextView) findViewById(R.id.analysisText);
        checkDataTitleView = (TitleView) findViewById(R.id.data_titleView);

        mLineChart = (LineChart) findViewById(R.id.lineChart);
        mLineChart.setDrawBorders(true);//显示边界
        mLineChart.animateX(200);//从左到右展开

        checkMarkView = new CheckMarkView(this, R.layout.chart_markview);
        checkMarkView.setChartView(mLineChart);
        mLineChart.setMarker(checkMarkView);

        if (getPresenter().getMemberSpinnerData() != null) {
            memberSp.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.spinnerTv, getPresenter().getMemberSpinnerData()));
        }
        if (getPresenter().getMemberSpinnerData() != null) {
            itemSp.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.spinnerTv, getPresenter().getItemSpinnerData()));
        }

//        getPresenter().chooseTimeclick(1);
        getPresenter().initChart(0, 0);
        getPresenter().chooseTimeclick(1);
        getPresenter().changeChartData(memberPositon, itemPositon);
    }

    @Override
    public void addListener() {
        thisTimeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().chooseTimeclick(1);
                getPresenter().changeChartData(memberPositon, itemPositon);
            }
        });

        weekBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().chooseTimeclick(2);
                getPresenter().changeChartData(memberPositon, itemPositon);
            }
        });

        monthBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().chooseTimeclick(3);
                getPresenter().changeChartData(memberPositon, itemPositon);
            }
        });

        yearBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().chooseTimeclick(4);
                getPresenter().changeChartData(memberPositon, itemPositon);
            }
        });

        /*spinner选中监听*/
        itemSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setItemPositon(position);
//                getPresenter().itemSelected(position);
                getPresenter().changeChartData(memberPositon, position);
                checkMarkView.setItem(getPresenter().getItemSpinnerData().get(position));
                mLineChart.animateX(200);//从左到右展开
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*spinner选中监听*/
        memberSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setMemberPositon(position);
//                getPresenter().memberSelected(position,itemPositon);
                getPresenter().changeChartData(position, itemPositon);
                mLineChart.animateX(200);//从左到右展开
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkDataTitleView.setBackBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void showChart(LineData data) {
        mLineChart.setData(data);
        mLineChart.invalidate();
        mLineChart.notifyDataSetChanged();
    }

    public void setItemPositon(int itemPositon) {
        this.itemPositon = itemPositon;
    }

    public void setMemberPositon(int memberPositon) {
        this.memberPositon = memberPositon;
    }

    public void setAnalysisText(String msg) {
        analysisText.setText(msg);
    }
}
