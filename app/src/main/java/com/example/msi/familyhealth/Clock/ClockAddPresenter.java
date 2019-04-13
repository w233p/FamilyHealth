package com.example.msi.familyhealth.Clock;
//public class ClockPresenter extends BasePresenter<ClockContacts.IClockView> implements ClockContacts.IClockPresenter {

import com.example.msi.familyhealth.MvpBase.BasePresenter;

public class ClockAddPresenter extends BasePresenter<ClockAddContacts.IClockAddView> implements ClockAddContacts.IClockAddPresenter {
    public ClockAddPresenter(ClockAddContacts.IClockAddView view) {
        super(view);
    }
}
