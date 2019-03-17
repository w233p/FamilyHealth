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

        String getState();

        /**
         * 注册、登陆、修改密码（成功/失败）
         */
        void loginSuccess();

        void loginFailure();

        void registerSuccess();

        void registerFailure();

        void changePasswordSuccess();

        void changePasswordFailure();

    }

    public interface ILoginPresenter extends IBasePresenter {
        void login(String username, String password);

        void register(String username, String password, String phone);

        void changePassword(String username, String phone, String newPassword);
    }

    public interface ILoginModel {

    }
}
