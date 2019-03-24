package com.example.msi.familyhealth.Data;

import java.sql.Date;
import java.sql.Time;

public class DbHealthDataBean {
    private int id;
    private float healthData;
    private Time healthTime;
    /**
     * 第几次记录
     * 此表中为体检数据，不常用
     * 用次数区分不同批次的数据
     */
    private int times;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHealthData() {
        return healthData;
    }

    public void setHealthData(float healthData) {
        this.healthData = healthData;
    }

    public Time getHealthTime() {
        return healthTime;
    }

    public void setHealthTime(Time healthTime) {
        this.healthTime = healthTime;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
