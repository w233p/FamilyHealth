package com.example.msi.familyhealth.Data;

/**
 * 基本健康信息Bean类
 * "性别","年龄","身高","体重"
 */
public class BaseItemBean {
    private boolean sex;
    private int age;
    private int height;
    private float weight;

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
