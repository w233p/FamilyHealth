package com.example.msi.familyhealth.Data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class DbMemberMessageBean extends DataSupport {
    private int id;
    private int age;
    private float height;
    private float weight;
    @Column(unique = true ,nullable = false)
    private DbMemberBean dbMemberBean;

    public DbMemberBean getDbMemberBean() {
        return dbMemberBean;
    }

    public DbMemberMessageBean setDbMemberBean(DbMemberBean dbMemberBean) {
        this.dbMemberBean = dbMemberBean;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public DbMemberMessageBean setAge(int age) {
        this.age = age;
        return this;
    }

    public float getHeight() {
        return height;
    }

    public DbMemberMessageBean setHeight(float height) {
        this.height = height;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public DbMemberMessageBean setWeight(float weight) {
        this.weight = weight;
        return this;
    }
}
