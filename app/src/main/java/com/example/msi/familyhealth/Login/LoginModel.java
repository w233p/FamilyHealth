package com.example.msi.familyhealth.Login;

import android.content.ContentValues;

import com.example.msi.familyhealth.Data.DbAccountBean;
import com.example.msi.familyhealth.Data.DbMemberBean;

import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class LoginModel implements LoginContacts.ILoginModel {

    public static final int LOGIN_SUCCESS = 0;
    public static final int LOGIN_FAIL_NOUSER = 1;
    public static final int LOGIN_FAIL_PASSWORDERROR = 2;

    public static final int REGISTER_SUCCESS = 3;
    public static final int REGISTER_FAIL_NAMEUSEED = 4;
    public static final int REGISTER_FAIL_PHONEUSEED = 5;
    public static final int REGISTER_FAIL_PHONEERROR = 6;
    public static final int REGISTER_FAIL_PASSWORDERROR = 7;
    public static final int REGISTER_FAIL_UNKNOWENERROR = 8;


    public static final int CHANGE_PASSWORD_SUCCESS = 9;
    public static final int CHANGE_FAIL_UNMARCH = 10;
    public static final int CHANGE_FAIL_PASSWORDERROR = 11;
    public static final int CHANGE_FAIL_NOUSER = 12;

    @Override
    public Integer login(String username, String password) {
        List<DbAccountBean> loginMember = DataSupport.where("username = ?", username).find(DbAccountBean.class);

        if (loginMember.size() == 0) {
            return LOGIN_FAIL_NOUSER;
        }

        if (loginMember.get(0).getPassword().equals(password)) {
            return LOGIN_SUCCESS;
        } else {
            return LOGIN_FAIL_PASSWORDERROR;
        }
    }

    @Override
    public Integer register(String username, String password, String phone) {
        List<DbAccountBean> registerName = DataSupport.where("username = ?", username).find(DbAccountBean.class);
        List<DbAccountBean> registerPhone = DataSupport.where("telephone = ?", phone).find(DbAccountBean.class);

        if (registerName.size() != 0) {
            return REGISTER_FAIL_NAMEUSEED;
        }

        if (registerPhone.size() != 0) {
            return REGISTER_FAIL_PHONEUSEED;
        }

        if (phone.length() != 11) {
            return REGISTER_FAIL_PHONEERROR;
        }

        if (password.length() < 6 || password.length() > 12) {
            return REGISTER_FAIL_PASSWORDERROR;
        }

        Date date = new Date();
        long dateTime = date.getTime();
        long zero = dateTime / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天0点的毫秒数
//        long twelve = zero + 24 * 60 * 60 * 1000 - 1;//今天23点59分59秒

        DbAccountBean registerAccountBean = new DbAccountBean().setUserName(username)
                .setPassword(password)
                .setTelephone(phone)
                .setRegisterTime(String.valueOf(zero));

        DbMemberBean dbMemberBean = new DbMemberBean().setMemberName(username)
                .setMemberTelephone(phone);
        if (registerAccountBean.save() && dbMemberBean.save()) {
            return REGISTER_SUCCESS;
        } else {
            return REGISTER_FAIL_UNKNOWENERROR;
        }
    }

    @Override
    public Integer changePassword(String username, String phone, String newPassword) {
        List<DbAccountBean> registerName = DataSupport.where("username = ?", username).find(DbAccountBean.class);
        if (registerName.size() == 0) {
            return CHANGE_FAIL_NOUSER;
        }

        if (newPassword.length() < 6 || newPassword.length() > 12) {
            return CHANGE_FAIL_PASSWORDERROR;
        }

        if (registerName.get(0).getTelephone().equals(phone)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("password", newPassword);
            DataSupport.update(DbAccountBean.class, contentValues, registerName.get(0).getId());
            return CHANGE_PASSWORD_SUCCESS;
        } else {
            return CHANGE_FAIL_UNMARCH;
        }
    }
}
