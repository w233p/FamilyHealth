package com.example.msi.familyhealth.CheckData;

import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.Data.DbProjectBean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class CheckDataModel implements CheckDataContacts.ICheakDataModel {

    List<String> project_item;
    List<String> member;

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
}
