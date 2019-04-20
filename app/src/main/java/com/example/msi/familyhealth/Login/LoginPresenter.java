package com.example.msi.familyhealth.Login;

import com.example.msi.familyhealth.MvpBase.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginContacts.ILoginView> implements LoginContacts.ILoginPresenter {
    private LoginModel loginModel = new LoginModel();

    public LoginPresenter(LoginContacts.ILoginView view) {
        super(view);
    }


    // public static final int LOGIN = 0;
    //    public static final int REGISTER = 1;
    //    public static final int CHANGE_PASSWORD = 2;
    @Override
    public void buttomBtClick(int state) {
        switch (state) {
            case LoginActivity.LOGIN:
                if (getView().passwordText().trim().equals("") && getView().userText().trim().equals("")) {
                    getView().loginFailure("请输入密码及用户名");
                } else {
                    switch (loginModel.login(getView().userText(), getView().passwordText())) {
                        case LoginModel.LOGIN_SUCCESS:
                            getView().loginSuccess();
                            break;
                        case LoginModel.LOGIN_FAIL_NOUSER:
                            getView().loginFailure("用户不存在");
                            break;
                        case LoginModel.LOGIN_FAIL_PASSWORDERROR:
                            getView().loginFailure("密码错误");
                            break;
                    }
                }
                break;
            case LoginActivity.REGISTER:
                if (getView().passwordText().trim().equals("") && getView().userText().trim().equals("") && getView().phoneText().trim().equals("")) {
                    getView().registerFailure("信息填写不完整");
                } else {
//                    getView().showToast(getView().passwordText() + getView().userText() + getView().phoneText());
                    switch (loginModel.register(getView().userText(), getView().passwordText(), getView().phoneText())) {
                        case LoginModel.REGISTER_SUCCESS:
                            getView().registerSuccess();
                            break;
                        case LoginModel.REGISTER_FAIL_NAMEUSEED:
                            getView().registerFailure("用户名已被注册");
                            break;
                        case LoginModel.REGISTER_FAIL_PASSWORDERROR:
                            getView().registerFailure("密码格式不合法");
                            break;
                        case LoginModel.REGISTER_FAIL_PHONEUSEED:
                            getView().registerFailure("该手机已注册");
                            break;
                        case LoginModel.REGISTER_FAIL_UNKNOWENERROR:
                            getView().registerFailure("写入数据库失败");
                            break;
                        case LoginModel.REGISTER_FAIL_PHONEERROR:
                            getView().registerFailure("手机号位数错误");
                            break;
                    }
                }
                break;
            case LoginActivity.CHANGE_PASSWORD:
                if (getView().passwordText().trim().equals("") && getView().userText().trim().equals("") && getView().phoneText().trim().equals("")) {
                    getView().registerFailure("信息填写不完整");
                } else {
                    switch (loginModel.changePassword(getView().userText(), getView().phoneText(), getView().passwordText())) {
                        case LoginModel.CHANGE_PASSWORD_SUCCESS:
                            getView().changePasswordSuccess();
                            break;
                        case LoginModel.CHANGE_FAIL_NOUSER:
                            getView().changePasswordFailure("用户名错误");
                            break;
                        case LoginModel.CHANGE_FAIL_UNMARCH:
                            getView().changePasswordFailure("手机号错误");
                            break;
                        case LoginModel.CHANGE_FAIL_PASSWORDERROR:
                            getView().changePasswordFailure("新密码格式不合法");
                            break;
                    }
                }

                break;
        }
    }
}
