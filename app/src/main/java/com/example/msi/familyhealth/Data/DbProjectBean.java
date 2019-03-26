package com.example.msi.familyhealth.Data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目表
 * 项目的大类名字
 */
public class DbProjectBean extends DataSupport {
    private int id;
    @Column(unique = true)
    private String project;
    /**
     * 与具体项目一对多的关系
     */
    private List<DbItemBean> dbItemBeanList = new ArrayList<DbItemBean>();

    public List<DbItemBean> getDbItemBeanList() {
        return dbItemBeanList;
    }

    public DbProjectBean setDbItemBeanList(List<DbItemBean> dbItemBeanList) {
        this.dbItemBeanList = dbItemBeanList;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public DbProjectBean setProject(String project) {
        this.project = project;
        return this;
    }

}
