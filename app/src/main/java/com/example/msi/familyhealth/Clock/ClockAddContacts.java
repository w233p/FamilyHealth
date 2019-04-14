package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

import java.util.List;

public class ClockAddContacts {
    public interface IClockAddView extends IBaseView {

    }

    public interface IClockAddPresenter extends IBasePresenter {
        public List<String> initMemberSp();

        public List<String> getRepeatData();

        public List<String> getTypeData();
    }

    public interface IClockAddModel {
        public List<String> memberSpinnerData();

        public List<String> repeatData();

        public List<String> TypeData();
    }


}
