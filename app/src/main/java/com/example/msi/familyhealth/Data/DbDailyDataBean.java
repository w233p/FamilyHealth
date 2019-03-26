package com.example.msi.familyhealth.Data;

import org.litepal.crud.DataSupport;

import java.sql.Date;
import java.sql.Time;



public class DbDailyDataBean extends DataSupport {
    private int id;
    private float data;
    private Long time;
    private DbMemberBean dbMemberBean;
    private DbItemBean dbItemBean;

    public DbMemberBean getDbMemberBean() {
        return dbMemberBean;
    }

    public DbDailyDataBean setDbMemberBean(DbMemberBean dbMemberBean) {
        this.dbMemberBean = dbMemberBean;
        return this;
    }

    public DbItemBean getDbItemBean() {
        return dbItemBean;
    }

    public DbDailyDataBean setDbItemBean(DbItemBean dbItemBean) {
        this.dbItemBean = dbItemBean;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getData() {
        return data;
    }

    public DbDailyDataBean setData(float data) {
        this.data = data;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public DbDailyDataBean setTime(Long time) {
        this.time = time;
        return this;
    }
}
