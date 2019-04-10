package com.example.msi.familyhealth.Data;

import org.litepal.crud.DataSupport;

public class DbClockBean extends DataSupport {
    private int id;
    private int type;
    private String medOrEventName;
    private DbMemberBean dbMemberBean;

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
}
