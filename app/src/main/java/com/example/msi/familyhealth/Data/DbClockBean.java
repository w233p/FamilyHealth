package com.example.msi.familyhealth.Data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class DbClockBean extends DataSupport {
    private int id;
    @Column(nullable = false)
    private int type;
    @Column(nullable = false)
    private int hour;
    @Column(nullable = false)
    private int minute;
    @Column(nullable = false)
    private String medOrEventName;
    @Column(nullable = false)
    private DbMemberBean dbMemberBean;
    @Column(nullable = false)
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public DbClockBean setType(int type) {
        this.type = type;
        return this;
    }

    public int getHour() {
        return hour;
    }

    public DbClockBean setHour(int hour) {
        this.hour = hour;
        return this;
    }

    public int getMinute() {
        return minute;
    }

    public DbClockBean setMinute(int minute) {
        this.minute = minute;
        return this;
    }

    public String getMedOrEventName() {
        return medOrEventName;
    }

    public DbClockBean setMedOrEventName(String medOrEventName) {
        this.medOrEventName = medOrEventName;
        return this;
    }

    public DbMemberBean getDbMemberBean() {
        return dbMemberBean;
    }

    public DbClockBean setDbMemberBean(DbMemberBean dbMemberBean) {
        this.dbMemberBean = dbMemberBean;
        return this;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
