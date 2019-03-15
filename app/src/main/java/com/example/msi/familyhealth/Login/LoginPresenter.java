package com.example.msi.familyhealth.Login;

import android.content.Intent;

import com.example.msi.familyhealth.Main.MainActivity;
import com.example.msi.familyhealth.MvpBase.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginContacts.ILoginView> implements LoginContacts.LoginPresenter {


    public LoginPresenter(LoginContacts.ILoginView view) {
        super(view);
    }

    @Override
    public void login(String username, String password) {
        if (username == "test" && password == "1") {
            getView().loginSuccess();
        }
    }

    @Override
    public void register(String username, String password, String phone) {

    }

    @Override
    public void changePassword(String username, String phone, String newPassword) {

    }
}
