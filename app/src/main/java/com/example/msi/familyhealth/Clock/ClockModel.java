package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.Data.DbClockBean;
import com.example.msi.familyhealth.Data.DbMemberBean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ClockModel implements ClockContacts.IClockModel {
    private List<String> member;
    List<DbMemberBean> dbMemberBeanList;
    List<DbClockBean> dbClockBeanList;

    /**
     * @param position 判断member
     *                 拿到对应member的闹钟数据
     * @return
     */
    @Override
    public List initListTypeData(int position) {
        List<Integer> typeList;
        typeList = new ArrayList<>();
        if (dbClockBeanList!=null){
            dbClockBeanList.clear();
        }
        dbClockBeanList = DataSupport.findAll(DbClockBean.class);
        for (int i = 0; i < dbClockBeanList.size(); i++) {
            typeList.add(dbClockBeanList.get(i).getType());
        }
        return typeList;
    }

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
        member.get(position);
    }
	
	public
}
