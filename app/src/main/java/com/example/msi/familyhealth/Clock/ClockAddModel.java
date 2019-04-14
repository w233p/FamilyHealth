package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.Data.DbMemberBean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ClockAddModel implements ClockAddContacts.IClockAddModel {
    List<DbMemberBean> dbMemberBeanList;
    List<String> member;

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

    public List<String> repeatData() {
        List<String> list = new ArrayList<>();
        list.add("单次");
        list.add("重复");
        return list;
    }

    @Override
    public List<String> TypeData() {
        List<String> list = new ArrayList<>();
        list.add("吃药");
        list.add("事件");
        return list;
    }
}
