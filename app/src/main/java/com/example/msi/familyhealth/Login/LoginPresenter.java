package com.example.msi.familyhealth.Login;

import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.example.msi.familyhealth.R;

public class LoginPresenter extends BasePresenter<LoginContacts.ILoginView> implements LoginContacts.ILoginPresenter {

    public LoginPresenter(LoginContacts.ILoginView view) {
        super(view);
    }

    @Override
    public void login(String username, String password) {
        if (isViewAttach()) {
            if (getView().getState() == getView().getSelfActivity().getString(R.string.login)) {
                if (username == "test" && password == "1") {
                    getView().loginSuccess();
                }
            } else if (getView().getState() == getView().getSelfActivity().getString(R.string.register)) {
                getView().showToast("现在是注册按钮");
            }

        }
    }

    @Override
    public void register(String username, String password, String phone) {

    }

    @Override
    public void changePassword(String username, String phone, String newPassword) {

    }
}
