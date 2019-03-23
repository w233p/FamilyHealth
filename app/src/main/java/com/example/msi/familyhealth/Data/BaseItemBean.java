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

    public BaseItemBean setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

    public int getAge() {
        return age;
    }

    public BaseItemBean setAge(int age) {
        this.age = age;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public BaseItemBean setHeight(int height) {
        this.height = height;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public BaseItemBean setWeight(float weight) {
        this.weight = weight;
        return this;
    }

}
