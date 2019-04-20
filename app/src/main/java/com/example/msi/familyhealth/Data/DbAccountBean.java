package com.example.msi.familyhealth.Data;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * 账号表
 * 均非空
 */
public class DbAccountBean extends DataSupport {
    private int id;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String registerTime;
    @Column(nullable = false)
    private String password;
    private String callNumber;//紧急联系人的电话

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public DbAccountBean setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public DbAccountBean setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public DbAccountBean setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DbAccountBean setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public DbAccountBean setCallNumber(String callNumber) {
        this.callNumber = callNumber;
        return this;
    }
}
