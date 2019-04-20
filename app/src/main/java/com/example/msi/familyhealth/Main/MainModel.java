package com.example.msi.familyhealth.Main;

import com.example.msi.familyhealth.Data.DbAccountBean;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainModel implements MainContacts.IMainModel {
    @Override
    public String getPhoneNumber() {
        return DataSupport.find(DbAccountBean.class,1).getCallNumber();
    }
}
