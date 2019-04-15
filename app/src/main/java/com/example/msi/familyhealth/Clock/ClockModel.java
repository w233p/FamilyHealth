package com.example.msi.familyhealth.Clock;

import android.util.Log;

import com.example.msi.familyhealth.Data.DbClockBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.View.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ClockModel implements ClockContacts.IClockModel {
    private List<String> member;
    private List<String> medList;
    private List<String> timeList;
    private String currentMember;
    List<DbMemberBean> dbMemberBeanList;
    List<DbClockBean> dbClockBeanList;

    /**
     * @return
     */
    @Override
    public List initListTypeData() {
        List<String> typeList;

        if (currentMember == null) {
            currentMember = member.get(0);
        }

        typeList = new ArrayList<>();
        if (dbClockBeanList != null) {
            dbClockBeanList.clear();
        }

        // 通过成员名找到其对应的闹钟数据，添加到类型表中
        dbClockBeanList = DataSupport.where("dbmemberbean_id = ?"
                , String.valueOf(DataSupport.where("membername =  ?"
                        , String.valueOf(currentMember))
                        .find(DbMemberBean.class)
                        .get(0)
                        .getId()))
                .find(DbClockBean.class);
        for (int i = 0; i < dbClockBeanList.size(); i++) {
            typeList.add(String.valueOf(dbClockBeanList.get(i).getType()));
        }
        return typeList;
    }

    /**
     * @return 返回所有的成员
     */
    @Override
    public List<String> memberSpinnerData() {
        dbMemberBeanList = DataSupport.findAll(DbMemberBean.class);
        member = new ArrayList<>();

        for (int i = 0; i < dbMemberBeanList.size(); i++) {
            member.add(dbMemberBeanList.get(i).getMemberName());
        }
        return member;
    }

    @Override
    public void setMember(int position) {
        if (member.size() > 0) {
            currentMember = member.get(position);
            Log.e("currentMember", currentMember);
            Log.e("memberList", member.get(position));
        }
    }

    public void getClockData(ViewHolder viewHolder) {

        if (medList == null) {
            medList = new ArrayList<>();
        } else {
            medList.clear();
        }

        if (timeList == null) {
            timeList = new ArrayList<>();
        } else {
            timeList.clear();
        }

        if (dbClockBeanList == null) {
            dbClockBeanList = DataSupport.where("membername = ?", String.valueOf(currentMember)).find(DbClockBean.class);
        }
        for (int i = 0; i < dbClockBeanList.size(); i++) {
            medList.add(dbClockBeanList.get(i).getMedOrEventName());
            timeList.add(dbClockBeanList.get(i).getHour() + ":" + dbClockBeanList.get(i).getMinute());
        }

        if (medList.size() == dbClockBeanList.size()) {
            Log.e("initClockList", "success");
        }

        viewHolder.initClockList(medList, timeList);
    }


}
