package com.example.msi.familyhealth.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目表
 * 项目的大类名字
 */
public class DbProjectBean {
    private int id;
    private String project;
    /**
     * 与具体项目一对多的关系
     */
    private List<DbItemBean> dbItemBeanList = new ArrayList<DbItemBean>();

    public List<DbItemBean> getDbItemBeanList() {
        return dbItemBeanList;
    }

    public void setDbItemBeanList(List<DbItemBean> dbItemBeanList) {
        this.dbItemBeanList = dbItemBeanList;
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

    public void setProject(String project) {
        this.project = project;
    }

}
