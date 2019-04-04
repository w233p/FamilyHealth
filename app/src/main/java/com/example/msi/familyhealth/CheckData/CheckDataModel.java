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
    List<Entry> entries;
    List<DbItemBean> dbItemBeanList;
    List<DbDailyDataBean> dbDailyDataBeanList;
    List<DbMemberBean> dbMemberBeanList;

    @Override
    public List<String> itemSpinnerData() {
        List<DbProjectBean> dbProjectBeanList = DataSupport.findAll(DbProjectBean.class);
        List<DbItemBean> dbItemBeanList = DataSupport.findAll(DbItemBean.class);
        project_item = new ArrayList<>();

//        for (int i = 0; i < dbProjectBeanList.size(); i++) {
//            project_item.add(dbProjectBeanList.get(i).getProject());
//        }
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
    public LineData setChartData(int memberPosition, int itemPosition) {


        /**
         * Entry 坐标点对象  构造函数 第一个参数为x点坐标 第二个为y点
         */
        if (dbMemberBeanList != null) {
            dbMemberBeanList.clear();
        }
        dbMemberBeanList = DataSupport
                .where("membername = ?", String.valueOf(member.get(memberPosition)))
                .find(DbMemberBean.class);
        Log.e("tag1", String.valueOf(member.get(memberPosition)));

        if (dbItemBeanList != null) {
            dbItemBeanList.clear();
        }
        dbItemBeanList = DataSupport
                .where("item = ?", String.valueOf(project_item.get(itemPosition)))
                .find(DbItemBean.class);

//        List<DbDailyDataBean> dbDailyDataBeanList =DataSupport
//                .where("dbmemberbean_id = ? and dbitembean_id = ?",dbMemberBeanList.get(0).getId(),dbItemBeanList.get(0).getId()).find(DbDailyDataBean.class);

        entries = new ArrayList<>();

        if (dbDailyDataBeanList != null) {
            dbDailyDataBeanList.clear();
        }
        if (DataSupport.where("dbmemberbean_id = ?", String.valueOf(dbMemberBeanList.get(0).getId())).find(DbDailyDataBean.class).size() > 1 &&
                DataSupport.where("dbitembean_id = ?", String.valueOf(dbItemBeanList.get(0).getId())).find(DbDailyDataBean.class).size() > 1) {
            dbDailyDataBeanList = DataSupport
                    .where("dbmemberbean_id = ?", String.valueOf(dbMemberBeanList.get(0).getId()))
                    .where("dbitembean_id = ?", String.valueOf(dbItemBeanList.get(0).getId()))
                    .find(DbDailyDataBean.class);
            for (int i = 0; i < dbDailyDataBeanList.size(); i++) {
                if (dbDailyDataBeanList != null) {
                    entries.add(new Entry(i, (float) dbDailyDataBeanList.get(i).getData()));
                }
            }
        } else {
            entries.add(new Entry(1, 0));
        }




        /**
         * LineDataSet每一个对象就是一条连接线
         */
        lineDataSet = new LineDataSet(entries, String.valueOf(project_item.get(itemPosition)));
        data = new LineData(lineDataSet);
        return data;
    }

    @Override
    public LineData changeChartName(int position) {
        lineDataSet.setLabel(String.valueOf(project_item.get(position)));
        data = new LineData(lineDataSet);
        return data;
    }

    @Override
    public LineData changeChartData(int memberPosition, int itemPosition) {
        dbItemBeanList.clear();
        dbMemberBeanList = DataSupport
                .where("membername = ?", String.valueOf(member.get(memberPosition)))
                .find(DbMemberBean.class);
        Log.e("changeChartData: ", String.valueOf(member.get(memberPosition)));

        dbItemBeanList.clear();
        dbItemBeanList = DataSupport
                .where("item = ?", String.valueOf(project_item.get(itemPosition)))
                .find(DbItemBean.class);

        dbDailyDataBeanList.clear();
        dbDailyDataBeanList = DataSupport
                .where("dbmemberbean_id = ?", String.valueOf(dbMemberBeanList.get(0).getId()))
                .where("dbitembean_id = ?", String.valueOf(dbItemBeanList.get(0).getId()))
                .find(DbDailyDataBean.class);

        entries = new ArrayList<>();
        for (int i = 0; i < dbDailyDataBeanList.size(); i++) {
            entries.add(new Entry(i, (float) dbDailyDataBeanList.get(i).getData()));
        }

        data.removeDataSet(lineDataSet);
        lineDataSet = new LineDataSet(entries, String.valueOf(project_item.get(itemPosition)));

        data.addDataSet(lineDataSet);
        return data;
    }

    public List<String> getProject_item() {
        return project_item;
    }

    public void setProject_item(List<String> project_item) {
        this.project_item = project_item;
    }

    public List<String> getMember() {
        return member;
    }

    public void setMember(List<String> member) {
        this.member = member;
    }

    public LineDataSet getLineDataSet() {
        return lineDataSet;
    }

    public void setLineDataSet(LineDataSet lineDataSet) {
        this.lineDataSet = lineDataSet;
    }

    public LineData getData() {
        return data;
    }

    public void setData(LineData data) {
        this.data = data;
    }

    public LineChart getLineChart() {
        return lineChart;
    }

    public void setLineChart(LineChart lineChart) {
        this.lineChart = lineChart;
    }
}
