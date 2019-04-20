package com.example.msi.familyhealth.Login;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

/**
 * 契约类，整合接口
 */
public class LoginContacts {
    /**
     * view层接口
     */
    public interface ILoginView extends IBaseView {
        @Override
        void initView();

        @Override
        void addListener();

        /**
         * 页面布局切换
         */
        void setLoginView();

        void setRegisterView();

        void setChangePasswordView();

        /**
         * 注册、登陆、修改密码（成功/失败）
         */
        void loginSuccess();

        void loginFailure(String message);

        void registerSuccess();

        void registerFailure(String msg);

        void changePasswordSuccess();

        void changePasswordFailure(String msg);

        String userText();

        String passwordText();

        String phoneText();
    }

    public interface ILoginPresenter extends IBasePresenter {
        void buttomBtClick(int state);
    }

    public interface ILoginModel {

        /**
         * @param username 登陆用户名
         * @param password 密码
         * @return 登陆结果
         */
        Integer login(String username, String password);

        Integer register(String username, String password, String phone);

        Integer changePassword(String username, String phone, String newPassword);
    }
}
