package com.example.msi.familyhealth.MyData;

import android.app.Fragment;

import com.example.msi.familyhealth.Data.DbDailyDataBean;
import com.example.msi.familyhealth.MvpBase.BaseFragment;
import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComContacts;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComModel;

public class MyDataPresenter extends BasePresenter<MyDataContacts.IMyDataView> implements MyDataContacts.IMyDataPresenter {
    MyDataModel myDataModel = new MyDataModel();

    public MyDataPresenter(MyDataContacts.IMyDataView view) {
        super(view);
    }

    public MyDataModel getMyDataModel() {
        return myDataModel;
    }

    public void setMyDataModel(MyDataModel myDataModel) {
        this.myDataModel = myDataModel;
    }

    public void initTemporaryData() {
        myDataModel.initTemporaryData();
    }

    public void initItemDataBase() {
        myDataModel.initItemDataBase();
    }

    /**
     * @param position
     * @param str      在viewholder里面监听到editText发生变化，调用方法更新数据中的临时存储数组
     */
    public void getEdit(int position, String str) {
        myDataModel.getEditText(position, str);
    }

    @Override
    public void writeDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen) {
        if (fragment_commen.getPresenter().getFragmentComModel().getProjectSpText().equals("日常")) {
            myDataModel.saveDailyToDb(fragment_commen);
        } else if (fragment_commen.getPresenter().getFragmentComModel().getProjectSpText().equals("基本信息")) {
            myDataModel.saveBaseToDb(fragment_commen);
        } else if (fragment_commen.getPresenter().getFragmentComModel().getProjectSpText().equals("血液")) {

        } else if (fragment_commen.getPresenter().getFragmentComModel().getProjectSpText().equals("尿检")) {

        } else if (fragment_commen.getPresenter().getFragmentComModel().getProjectSpText().equals("糖尿病")) {

        }

    }

}
