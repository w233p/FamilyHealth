package com.example.msi.familyhealth.CheckData;

import android.util.Log;

import com.example.msi.familyhealth.Data.DbDailyDataBean;
import com.example.msi.familyhealth.Data.DbHealthDataBean;
import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CheckDataModel implements CheckDataContacts.ICheakDataModel {

    private List<String> project_item;
    private List<String> member;
    private LineDataSet lineDataSet;
    private LineData data;
    private LineChart lineChart;
    private int itemPosition;

    List<Entry> entries = null;
    List<DbItemBean> dbItemBeanList;
    List<DbDailyDataBean> dbDailyDataBeanList;
    List<DbMemberBean> dbMemberBeanList;
    List<DbHealthDataBean> dbHealthDataBeanList;

    public String result = null;
    public long ONE_DAY_MILLISECONEDS = 24 * 60 * 60 * 1000;
    public long yearTime;//大于一年前
    public long monthTime;
    public long weekTime;
    public long dateTime;
    public long zero;//大于今晚0点
    public long twelve;
    public long chartTime;//显示在此时间之后的数据

    @Override
    public List<String> itemSpinnerData() {
        List<DbItemBean> dbItemBeanList = DataSupport.findAll(DbItemBean.class);
        project_item = new ArrayList<>();

        for (int i = 0, len = dbItemBeanList.size(); i < len; i++) {
            project_item.add(dbItemBeanList.get(i).getItem());
        }
        return project_item;
    }


    //注：初始化时运行了3次
    @Override
    public List<String> memberSpinnerData() {
        List<DbMemberBean> dbMemberBeanList = DataSupport.findAll(DbMemberBean.class);
        member = new ArrayList<>();

        for (int i = 0, len = dbMemberBeanList.size(); i < len; i++) {
            member.add(dbMemberBeanList.get(i).getMemberName());
        }

        return member;
    }

    public void initTime() {
        Calendar calendar = Calendar.getInstance();
        //前一年的毫秒
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1);
        Date year = calendar.getTime();
        yearTime = year.getTime();
        //前一月的毫秒
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date month = calendar.getTime();
        monthTime = month.getTime();
        //前一周的毫秒
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -7);
        Date week = calendar.getTime();
        weekTime = week.getTime();
        //今天零点到24点的毫秒
        Date date = new Date();
        dateTime = date.getTime();
        zero = dateTime / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天0点的毫秒数
        twelve = zero + 24 * 60 * 60 * 1000 - 1;//今天23点59分59秒
    }

    @Override
    public LineData setChartData(int memberPosition, int itemPosition) {
        this.itemPosition = itemPosition;

        initTime();

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

        if (entries == null) {
            entries = new ArrayList<>();
        } else {
            entries.clear();
        }

        if (dbDailyDataBeanList != null) {
            dbDailyDataBeanList.clear();
        }
        if (dbHealthDataBeanList != null) {
            dbHealthDataBeanList.clear();
        }
        Log.e("position", String.valueOf(itemPosition));

        chooseBean(itemPosition);

        /**
         * LineDataSet每一个对象就是一条连接线
         */
        lineDataSet = new LineDataSet(entries, String.valueOf(project_item.get(itemPosition)));
        data = new LineData(lineDataSet);
        return data;
    }

    @Override
    public LineData changeChartLabel(int position) {
        lineDataSet.setLabel(String.valueOf(project_item.get(position)));
        data = new LineData(lineDataSet);
        return data;
    }
/**
 * 与setchanrtdata代码逻辑重复*/
//    @Override
//    public LineData changeChartData(int memberPosition, int itemPosition) {
//        this.itemPosition = itemPosition;
//        dbMemberBeanList.clear();
//        dbMemberBeanList = DataSupport
//                .where("membername = ?", String.valueOf(member.get(memberPosition)))
//                .find(DbMemberBean.class);
//        Log.e("changeChartData: ", String.valueOf(member.get(memberPosition)));
//
//        dbItemBeanList.clear();
//        dbItemBeanList = DataSupport
//                .where("item = ?", String.valueOf(project_item.get(itemPosition)))
//                .find(DbItemBean.class);
//
//        entries = new ArrayList<>();
//
//        chooseBean(itemPosition);
//
//        data.removeDataSet(lineDataSet);
//        lineDataSet = new LineDataSet(entries, String.valueOf(project_item.get(itemPosition)));
//
//        data.addDataSet(lineDataSet);
//        return data;
//    }

    private void chooseBean(int itemPosition) {
        this.itemPosition = itemPosition;
        if (itemPosition > -1 && itemPosition < 3) {
            if (DataSupport.where("dbmemberbean_id = ?", String.valueOf(dbMemberBeanList.get(0).getId())).find(DbDailyDataBean.class).size() >= 1 &&
                    DataSupport.where("dbitembean_id = ?", String.valueOf(dbItemBeanList.get(0).getId())).find(DbDailyDataBean.class).size() >= 1) {
                dbDailyDataBeanList = DataSupport
                        .where("dbitembean_id = ? and dbmemberbean_id = ?"
                                , String.valueOf(dbItemBeanList.get(0).getId())
                                , String.valueOf(dbMemberBeanList.get(0).getId()))
                        .find(DbDailyDataBean.class);
                chooseTime(dbDailyDataBeanList);
            } else {
                entries.add(new Entry(1, 0));
            }
        } else if (itemPosition > 2) {
            if (DataSupport.where("dbmemberbean_id = ?", String.valueOf(dbMemberBeanList.get(0).getId())).find(DbHealthDataBean.class).size() >= 1 &&
                    DataSupport.where("dbitembean_id = ?", String.valueOf(dbItemBeanList.get(0).getId())).find(DbHealthDataBean.class).size() >= 1) {
                dbHealthDataBeanList = DataSupport
                        .where("dbitembean_id = ? and dbmemberbean_id = ?"
                                , String.valueOf(dbItemBeanList.get(0).getId())
                                , String.valueOf(dbMemberBeanList.get(0).getId()))
                        .find(DbHealthDataBean.class);

                chooseTime(dbHealthDataBeanList);
            } else {
                entries.add(new Entry(1, 0));
            }
        }
    }

    private void chooseTime(List list) {
        if (list.equals(dbDailyDataBeanList)) {
            List<Float> data = new ArrayList<>();
            for (int i = 0,len =dbDailyDataBeanList.size(); i < len; i++) {
                if (dbDailyDataBeanList.get(i).getTime() > chartTime && dbDailyDataBeanList != null) {
                    data.add((float) dbDailyDataBeanList.get(i).getData());
                    entries.add(new Entry(i, (float) dbDailyDataBeanList.get(i).getData()));
                }
            }
            result = DataAnalysis.dailyDataAnalysis(data, itemPosition);
            if (entries.size() == 0) {
                entries.add(new Entry(1, 0));
            }
        } else if (list.equals(dbHealthDataBeanList)) {
            for (int i = 0,len = dbHealthDataBeanList.size();i < len; i++) {
                if (dbHealthDataBeanList.get(i).getHealthTime() > chartTime && dbHealthDataBeanList != null) {
                    entries.add(new Entry(i, (float) dbHealthDataBeanList.get(i).getHealthData()));
                }
            }
            if (entries.size() == 0) {
                entries.add(new Entry(1, 0));
            }
        }
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
