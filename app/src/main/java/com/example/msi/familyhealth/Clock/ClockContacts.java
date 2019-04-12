package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

import java.util.List;

public class ClockContacts {
    public interface IClockView extends IBaseView {
        public void setClockListAdapter();

        public void refreshClockListAdapter();
		
		public void setMedViewHolder(List medList,List timeList);
		
		public void setEventViewHolder(List eventList,List timeList);
		}

    public interface IClockPresenter extends IBasePresenter {
        public List initList();

        public List<String> initTitleMemberSp();

        public void memberSelect(int position);
		
		public void setMedListUi();
		
		public void setEventListUi();
    }

    public interface IClockModel {
        public List initListTypeData(int position);

        public List<String> memberSpinnerData();

        public void setMember(int position);
    }
}
