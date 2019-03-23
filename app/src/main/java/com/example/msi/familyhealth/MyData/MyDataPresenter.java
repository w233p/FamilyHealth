package com.example.msi.familyhealth.MyData;

import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComContacts;

public class MyDataPresenter extends BasePresenter<MyDataContacts.IMyDataView> implements  MyDataContacts.IMyDataPresenter {

    public MyDataPresenter(MyDataContacts.IMyDataView view) {
        super(view);
    }
}
