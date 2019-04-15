package com.example.msi.familyhealth.Clock;
//public class ClockPresenter extends BasePresenter<ClockContacts.IClockView> implements ClockContacts.IClockPresenter {

import com.example.msi.familyhealth.MvpBase.BasePresenter;

import java.util.List;

import android.content.*;

public class ClockAddPresenter extends BasePresenter<ClockAddContacts.IClockAddView> implements ClockAddContacts.IClockAddPresenter {
    ClockAddModel clockAddModel = new ClockAddModel();

    public ClockAddPresenter(ClockAddContacts.IClockAddView view) {
        super(view);
    }

    @Override
    public List<String> initMemberSp() {
        return clockAddModel.memberSpinnerData();
    }

    @Override
    public List<String> getRepeatData() {
        return clockAddModel.repeatData();
    }

    @Override
    public List<String> getTypeData() {
        return clockAddModel.TypeData();
    }

    public void addClockBtClick(Context context, int type, int repeat, int hour, int minute, String medOrEventName, String memberName) {
        clockAddModel.setClockDb(context, type, repeat, hour, minute, medOrEventName, memberName);
        getView().setClockOver();
    }
}
