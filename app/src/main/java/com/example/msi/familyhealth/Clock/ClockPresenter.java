package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.example.msi.familyhealth.MvpBase.IBasePresenter;

import java.util.List;

public class ClockPresenter extends BasePresenter<ClockContacts.IClockView> implements ClockContacts.IClockPresenter {
    ClockModel clockModel = new ClockModel();

    public ClockPresenter(ClockContacts.IClockView view) {
        super(view);
    }

    @Override
    public List initList() {
        return clockModel.initListTypeData(0);
    }

    @Override
    public List<String> initTitleMemberSp() {
        return clockModel.memberSpinnerData();
    }

    @Override
    public void memberSelect(int position) {
//        getView().setClockListAdapter(clockModel.initListTypeData(0));
        getView().refreshClockListAdapter();
    }
}
