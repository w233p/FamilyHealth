package com.example.msi.familyhealth.Main;

import android.content.Context;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

/**
 * 契约类，整合接口
 */
public class MainContacts {
    /**
     * view层接口
     */
    public interface IMainView extends IBaseView {
        @Override
        void initView();

        @Override
        void addListener();

        @Override
        void showDialog();
    }

    public interface IMainPresenter extends IBasePresenter {
        void call(Context context);
    }

    public interface IMainModel {
        String getPhoneNumber();
    }
}
