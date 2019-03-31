package com.example.msi.familyhealth.MyData;

import android.app.Fragment;

import com.example.msi.familyhealth.MvpBase.BaseFragment;
import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComContacts;

public class MyDataContacts {
    public interface IMyDataView extends IBaseView {
        @Override
        void initView();

        @Override
        void addListener();

        void initData();
    }

    public interface IMyDataPresenter extends IBasePresenter {
        MyDataModel getMyDataModel();

        void initTemporaryData();

        void initItemDataBase();

        void getEdit(int position, String str);

        void writeDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen);
    }

    public interface IMyDataModel {
        /**
         * 初始化临时数据存储数组
         */
        void initTemporaryData();

        /**
         * 获取EditText的值,保存到临时数组
         */
        void getEditText(int position, String str);

        /**
         * 转换类型
         */
        int getInt(int dataPosition);

        float getFloat(int dataPosition);

        void saveBaseToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen);

        void saveDailyToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen);

        void saveBloodToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen);

        void saveUrineToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen);

        void saveInsulinToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen);

    }
}
