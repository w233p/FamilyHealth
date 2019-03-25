package com.example.msi.familyhealth.Data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 亲友成员表
 */
public class DbMemberBean extends DataSupport {
    private int id;
    private String memberTelephone;
    @Column(unique = true)
    private String memberName;
    /**
     * 一个亲友对应一个亲友的信息
     * 亲友信息中会多一个亲友的键
     */
    @Column(unique = true)
    private DbMemberMessageBean dbMemberMessageBean;

    /**
     * 一个亲友有多条健康数据
     */
    private List<DbDailyDataBean> dbDailyDataBeanList = new ArrayList<DbDailyDataBean>();

    /**
     * 一个亲友对应多条病史
     */
    private List<DbHealthHistoryBean> dbHealthHistoryBeanList = new ArrayList<DbHealthHistoryBean>();

    /**
     * 定位映射
     */
    private List<DbPositonBean> dbPositonBeanList = new ArrayList<DbPositonBean>();

    public List<DbPositonBean> getDbPositonBeanList() {
        return dbPositonBeanList;
    }

    public DbMemberBean setDbPositonBeanList(List<DbPositonBean> dbPositonBeanList) {
        this.dbPositonBeanList = dbPositonBeanList;
        return this;
    }

    public List<DbHealthHistoryBean> getDbHealthHistoryBeanList() {
        return dbHealthHistoryBeanList;
    }

    public DbMemberBean setDbHealthHistoryBeanList(List<DbHealthHistoryBean> dbHealthHistoryBeanList) {
        this.dbHealthHistoryBeanList = dbHealthHistoryBeanList;
        return this;
    }

    public DbMemberMessageBean getDbMemberMessageBean() {
        return dbMemberMessageBean;
    }

    public DbMemberBean setDbMemberMessageBean(DbMemberMessageBean dbMemberMessageBean) {
        this.dbMemberMessageBean = dbMemberMessageBean;
        return this;
    }

    public List<DbDailyDataBean> getDbDailyDataBeanList() {
        return dbDailyDataBeanList;
    }

    public DbMemberBean setDbDailyDataBeanList(List<DbDailyDataBean> dbDailyDataBeanList) {
        this.dbDailyDataBeanList = dbDailyDataBeanList;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberTelephone() {
        return memberTelephone;
    }

    public DbMemberBean setMemberTelephone(String memberTelephone) {
        this.memberTelephone = memberTelephone;
        return this;
    }

    public String getMemberName() {
        return memberName;
    }

    public DbMemberBean setMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }
}
