package com.example.msi.familyhealth.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 亲友成员表
 */
public class DbMemberBean {
    private int id;
    private String memberTelephone;
    private String memberName;
    /**
     * 一个亲友对应一个亲友的信息
     * 亲友信息中会多一个亲友的键
     */
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

    public void setDbPositonBeanList(List<DbPositonBean> dbPositonBeanList) {
        this.dbPositonBeanList = dbPositonBeanList;
    }

    public List<DbHealthHistoryBean> getDbHealthHistoryBeanList() {
        return dbHealthHistoryBeanList;
    }

    public void setDbHealthHistoryBeanList(List<DbHealthHistoryBean> dbHealthHistoryBeanList) {
        this.dbHealthHistoryBeanList = dbHealthHistoryBeanList;
    }

    public DbMemberMessageBean getDbMemberMessageBean() {
        return dbMemberMessageBean;
    }

    public void setDbMemberMessageBean(DbMemberMessageBean dbMemberMessageBean) {
        this.dbMemberMessageBean = dbMemberMessageBean;
    }

    public List<DbDailyDataBean> getDbDailyDataBeanList() {
        return dbDailyDataBeanList;
    }

    public void setDbDailyDataBeanList(List<DbDailyDataBean> dbDailyDataBeanList) {
        this.dbDailyDataBeanList = dbDailyDataBeanList;
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

    public void setMemberTelephone(String memberTelephone) {
        this.memberTelephone = memberTelephone;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


}
