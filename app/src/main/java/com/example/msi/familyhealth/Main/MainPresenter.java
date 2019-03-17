package com.example.msi.familyhealth.Main;

import com.example.msi.familyhealth.MvpBase.BasePresenter;

public class MainPresenter extends BasePresenter<MainContacts.IMainView> implements MainContacts.IMainPresenter {
    public MainPresenter(MainContacts.IMainView view) {
        super(view);
    }
}
