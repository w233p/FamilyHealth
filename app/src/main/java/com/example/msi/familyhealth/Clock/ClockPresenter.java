package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.example.msi.familyhealth.View.ViewHolder;

import java.util.List;

public class ClockPresenter extends BasePresenter<ClockContacts.IClockView> implements ClockContacts.IClockPresenter {
    ClockModel clockModel = new ClockModel();

    public ClockPresenter(ClockContacts.IClockView view) {
        super(view);
    }

    @Override
    public List initTypeList() {
        return clockModel.initListTypeData();
    }

    @Override
    public List<String> initTitleMemberSp() {
        return clockModel.memberSpinnerData();
    }

    @Override
    public void memberSelect(int position) {
//        getView().setClockListAdapter(clockModel.initListTypeData(0));
        clockModel.setMember(position);
        getView().refreshClockListAdapter();
        getView().setClockListAdapter();
    }

    @Override
    public void initClockData(ViewHolder viewHolder) {
        clockModel.getClockData(viewHolder);
    }
}
