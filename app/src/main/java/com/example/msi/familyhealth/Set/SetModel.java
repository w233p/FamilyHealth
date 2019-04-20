package com.example.msi.familyhealth.Set;

import com.example.msi.familyhealth.Data.DbMemberBean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

//<!--<TextView-->
//		<!--android:id="@id/acountTv linkMember Jianhuren CallNumber ExitAcount ExitApp"/>-->
//    <!---->
public class SetModel implements SetContacts.ISetModel {
    @Override
    public List<String> initSetListDataItem() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("账号");
        dataList.add("添加家人");
        dataList.add("1");
        dataList.add("监护人选项");
        dataList.add("紧急呼叫号码");
        dataList.add("1");
        dataList.add("退出账号");
        dataList.add("退出软件");
        return dataList;
    }


    @Override
    public boolean addMember(String memberName, String phone) {
        DbMemberBean dbMemberBean = new DbMemberBean()
                .setMemberName(memberName)
                .setMemberTelephone(phone);

        return dbMemberBean.save();
    }

    @Override
    public String[] getMember() {
        List<DbMemberBean> dbMemberBeanList = DataSupport.findAll(DbMemberBean.class);
        String[] memberName = new String[dbMemberBeanList.size()];
        for (int i = 0; i < dbMemberBeanList.size(); i++) {
            memberName[i] = dbMemberBeanList.get(i).getMemberName();
        }

        return memberName;
    }

    @Override
    public String phoneNumber(int position) {
        List<DbMemberBean> dbMemberBeanList = DataSupport.findAll(DbMemberBean.class);

        return dbMemberBeanList.get(position).getMemberTelephone();
    }
}
