package com.example.msi.familyhealth.Data;

/**
 * 日常项目的Bean类
 * "血糖","血脂","血压"
 */
public class DailyBean {
    private float bloodSugar;
    private float bloodFat;
    private float bloodPressure;

    public float getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(float bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public float getBloodFat() {
        return bloodFat;
    }

    public void setBloodFat(float bloodFat) {
        this.bloodFat = bloodFat;
    }

    public float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
}

