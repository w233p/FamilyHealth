package com.example.msi.familyhealth.CheckData;

import android.util.Log;

import com.example.msi.familyhealth.Data.DbDailyDataBean;
import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class CheckDataModel implements CheckDataContacts.ICheakDataModel {

    private List<String> project_item;
    private List<String> member;
    private LineDataSet lineDataSet;
    private LineData data;
    private LineChart lineChart;

    @Override
    public List<String> itemSpinnerData() {
        List<DbProjectBean> dbProjectBeanList = DataSupport.findAll(DbProjectBean.class);
        List<DbItemBean> dbItemBeanList = DataSupport.findAll(DbItemBean.class);
        project_item = new ArrayList<>();

        for (int i = 0; i < dbProjectBeanList.size(); i++) {
            project_item.add(dbProjectBeanList.get(i).getProject());
        }
        for (int i = 0; i < dbItemBeanList.size(); i++) {
            project_item.add(dbItemBeanList.get(i).getItem());
        }
        return project_item;
    }

    @Override
    public List<String> memberSpinnerData() {
        List<DbMemberBean> dbMemberBeanList = DataSupport.findAll(DbMemberBean.class);
        member = new ArrayList<>();

        for (int i = 0; i < dbMemberBeanList.size(); i++) {
            member.add(dbMemberBeanList.get(i).getMemberName());
        }
        return member;
    }

    @Override
    public void setChartData(LineChart mLineChart) {
        this.lineChart = mLineChart;

        /**
         * Entry 坐标点对象  构造函数 第一个参数为x点坐标 第二个为y点
         */
        List<DbMemberBean> dbMemberBeanList = DataSupport
                .where("membername = ?", String.valueOf(member.get(0)))
                .find(DbMemberBean.class);


        List<DbItemBean> dbItemBeanList = DataSupport
                .where("item = ?", String.valueOf(project_item.get(5)))
                .find(DbItemBean.class);


//        List<DbDailyDataBean> dbDailyDataBeanList =DataSupport
//                .where("dbmemberbean_id = ? and dbitembean_id = ?",dbMemberBeanList.get(0).getId(),dbItemBeanList.get(0).getId()).find(DbDailyDataBean.class);

        List<DbDailyDataBean> dbDailyDataBeanList = DataSupport
                .where("dbmemberbean_id = ?", String.valueOf(dbMemberBeanList.get(0).getId()))
                .where("dbitembean_id = ?", String.valueOf(dbItemBeanList.get(0).getId()))
                .find(DbDailyDataBean.class);

        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < dbDailyDataBeanList.size(); i++) {
            entries.add(new Entry(i, (float) dbDailyDataBeanList.get(i).getData()));
        }

        /**
         * LineDataSet每一个对象就是一条连接线
         */
        lineDataSet = new LineDataSet(entries, String.valueOf(project_item));
        data = new LineData(lineDataSet);
        mLineChart.setData(data);
        mLineChart.invalidate();
    }

    @Override
    public void changeChartName(int position) {
        lineDataSet.setLabel(String.valueOf(project_item.get(position)));
        data = new LineData(lineDataSet);
        lineChart.setData(data);
        lineChart.invalidate();
    }

    @Override
    public void changeChartData(int memberPositon, int itemPositon) {

    }
}
