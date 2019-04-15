package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

import java.util.List;
import android.content.*;

public class ClockAddContacts {
    public interface IClockAddView extends IBaseView {
		public void setClockOver();

    }

    public interface IClockAddPresenter extends IBasePresenter {
        public List<String> initMemberSp();

        public List<String> getRepeatData();

        public List<String> getTypeData();
		
		public void addClockBtClick(Context context, int type,int hour,int minute,String medOrEventName,String memberName);
    }

    public interface IClockAddModel {
        public List<String> memberSpinnerData();

        public List<String> repeatData();

        public List<String> TypeData();
		
		public void setClockDb(Context context, int type,int hour,int minute,String medOrEventName,String memberName);
    }


}
