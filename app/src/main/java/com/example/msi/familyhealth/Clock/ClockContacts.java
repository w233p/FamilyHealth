package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;
import com.example.msi.familyhealth.View.ViewHolder;

import java.util.List;

public class ClockContacts {
    public interface IClockView extends IBaseView {
        public void setClockListAdapter();

        public void refreshClockListAdapter();

    }

    public interface IClockPresenter extends IBasePresenter {
        public List initTypeList();

        public List<String> initTitleMemberSp();

        public void memberSelect(int position);

        void initClockData(ViewHolder viewHolder);

    }

    public interface IClockModel {
        public List initListTypeData();

        public List<String> memberSpinnerData();

        public void setMember(int position);

    }
}
