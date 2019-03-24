package com.example.msi.familyhealth.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体数据项目表
 */
public class DbItemBean {
    private int id;
    private String item;
    /**
     * 一个具体项目对应一个大类
     */
    private DbProjectBean dbProjectBean;

    /**
     * 很多数据都引用具体项目
     */
    private List<DbDailyDataBean> dbDailyDataBeanList = new ArrayList<DbDailyDataBean>();

    /**
     * 体检数据的项目引用具体项目
     */
    private List<DbHealthDataBean> dbHealthDataBeanList = new ArrayList<DbHealthDataBean>();

    public List<DbHealthDataBean> getDbHealthDataBeanList() {
        return dbHealthDataBeanList;
    }

    public void setDbHealthDataBeanList(List<DbHealthDataBean> dbHealthDataBeanList) {
        this.dbHealthDataBeanList = dbHealthDataBeanList;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public DbProjectBean getDbProjectBean() {
        return dbProjectBean;
    }

    public void setDbProjectBean(DbProjectBean dbProjectBean) {
        this.dbProjectBean = dbProjectBean;
    }


}
