package com.example.msi.familyhealth.Data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体数据项目表
 */
public class DbItemBean extends DataSupport {
    private int id;
    @Column(unique = true)
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

    public DbItemBean setDbHealthDataBeanList(List<DbHealthDataBean> dbHealthDataBeanList) {
        this.dbHealthDataBeanList = dbHealthDataBeanList;
        return this;
    }

    public List<DbDailyDataBean> getDbDailyDataBeanList() {
        return dbDailyDataBeanList;
    }

    public DbItemBean setDbDailyDataBeanList(List<DbDailyDataBean> dbDailyDataBeanList) {
        this.dbDailyDataBeanList = dbDailyDataBeanList;
        return this;
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

    public DbItemBean setItem(String item) {
        this.item = item;
        return this;
    }

    public DbProjectBean getDbProjectBean() {
        return dbProjectBean;
    }

    public DbItemBean setDbProjectBean(DbProjectBean dbProjectBean) {
        this.dbProjectBean = dbProjectBean;
        return this;
    }


}
