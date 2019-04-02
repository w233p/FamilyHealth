package com.example.msi.familyhealth.CheckData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckDataActivity extends BaseActivity<CheckDataContacts.ICheckDataPresenter> implements CheckDataContacts.ICheckDataView {

    private Spinner itemSp;
    private Spinner memberSp;
    private LineChart mLineChart;
    private int itemPositon;
    private int memberPositon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_chart);

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

        mLineChart = (LineChart)findViewById(R.id.lineChart);
        mLineChart.setDrawBorders(true);//显示边界

        memberSp.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.spinnerTv, getPresenter().getMemberSpinnerData()));
        itemSp.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.spinnerTv, getPresenter().getItemSpinnerData()));

        getPresenter().showChart(mLineChart);

    }

    @Override
    public void addListener() {
        /*spinner选中监听*/
        itemSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setItemPositon(position);
                getPresenter().itemSelected(position);
                getPresenter().changeChartData(memberPositon,position);
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
                getPresenter().changeChartData(position,itemPositon);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setItemPositon(int itemPositon) {
        this.itemPositon = itemPositon;
    }

    public void setMemberPositon(int memberPositon) {
        this.memberPositon = memberPositon;
    }

    public void initItemDataBase() {
        DbProjectBean dbProjectBean = new DbProjectBean().setProject("日常");
        dbProjectBean.save();
        DbProjectBean dbProjectBean1 = new DbProjectBean().setProject("血液");
        dbProjectBean1.save();
        DbProjectBean dbProjectBean2 = new DbProjectBean().setProject("尿检");
        dbProjectBean2.save();
        DbProjectBean dbProjectBean3 = new DbProjectBean().setProject("糖尿病");
        dbProjectBean3.save();
        DbProjectBean dbProjectBean4 = new DbProjectBean().setProject("基本信息");
        dbProjectBean4.save();

        DbItemBean dbItemBean = new DbItemBean().setItem("血糖");
        dbItemBean.setDbProjectBean(dbProjectBean).save();
        DbItemBean dbItemBean1 = new DbItemBean().setItem("高压");
        dbItemBean1.setDbProjectBean(dbProjectBean).save();
        DbItemBean dbItemBean2 = new DbItemBean().setItem("低压");
        dbItemBean2.setDbProjectBean(dbProjectBean).save();
//        "甘油三酯", "胆固醇", "红细胞", "红细胞体积分布宽度", "白细胞", "血小板"
//            , "糖化血红蛋白", "心肌酶", "血尿酸"
        DbItemBean dbItemBean3 = new DbItemBean().setItem("甘油三酯");
        dbItemBean3.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean4 = new DbItemBean().setItem("胆固醇");
        dbItemBean4.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean5 = new DbItemBean().setItem("红细胞");
        dbItemBean5.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean6 = new DbItemBean().setItem("红细胞体积分布宽度");
        dbItemBean6.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean7 = new DbItemBean().setItem("白细胞");
        dbItemBean7.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean8 = new DbItemBean().setItem("血小板");
        dbItemBean8.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean9 = new DbItemBean().setItem("糖化血红蛋白");
        dbItemBean9.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean10 = new DbItemBean().setItem("心肌酶");
        dbItemBean10.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean11 = new DbItemBean().setItem("血尿酸");
        dbItemBean11.setDbProjectBean(dbProjectBean1).save();
//        {"PH", "蛋白质", "比重", "潜血", "微量白蛋白", "肌酐"};
        DbItemBean dbItemBean12 = new DbItemBean().setItem("PH");
        dbItemBean12.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean13 = new DbItemBean().setItem("蛋白质");
        dbItemBean13.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean14 = new DbItemBean().setItem("比重");
        dbItemBean14.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean15 = new DbItemBean().setItem("潜血");
        dbItemBean15.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean16 = new DbItemBean().setItem("微量白蛋白");
        dbItemBean16.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean17 = new DbItemBean().setItem("肌酐");
        dbItemBean17.setDbProjectBean(dbProjectBean2).save();
//        "胰岛素","ICA抗胰岛细胞抗体","GAD抗谷氨酸脱氢酶抗体","IAA抗胰岛素抗体"
        DbItemBean dbItemBean18 = new DbItemBean().setItem("胰岛素");
        dbItemBean18.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean19 = new DbItemBean().setItem("ICA抗胰岛细胞抗体");
        dbItemBean19.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean20 = new DbItemBean().setItem("GAD抗谷氨酸脱氢酶抗体");
        dbItemBean20.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean21 = new DbItemBean().setItem("IAA抗胰岛素抗体");
        dbItemBean21.setDbProjectBean(dbProjectBean2).save();
    }
}
