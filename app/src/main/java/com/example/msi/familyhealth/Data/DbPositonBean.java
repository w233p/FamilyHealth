package com.example.msi.familyhealth.Data;

import org.litepal.crud.DataSupport;

import java.sql.Time;

/**
 * 定位表
 */
public class DbPositonBean extends DataSupport {
    private int id;
    private Time positonTime;
    private String LocalX;//经度
    private String LocalY;//纬度

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getPositonTime() {
        return positonTime;
    }

    public void setPositonTime(Time positonTime) {
        this.positonTime = positonTime;
    }

    public String getLocalX() {
        return LocalX;
    }

    public void setLocalX(String localX) {
        LocalX = localX;
    }

    public String getLocalY() {
        return LocalY;
    }

    public void setLocalY(String localY) {
        LocalY = localY;
    }


}
