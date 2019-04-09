package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.example.msi.familyhealth.MvpBase.IBasePresenter;

public class ClockPresenter extends BasePresenter<ClockContacts.IClockView> implements ClockContacts.IClockPresenter {
    public ClockPresenter(ClockContacts.IClockView view) {
        super(view);
    }
}
