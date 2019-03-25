package com.example.msi.familyhealth.Data;

import org.litepal.crud.DataSupport;

public class DbHealthHistoryBean extends DataSupport {
    private int id;
    private String histroy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHistroy() {
        return histroy;
    }

    public void setHistroy(String histroy) {
        this.histroy = histroy;
    }
}
