package com.example.msi.familyhealth.CheckData;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

import java.util.List;

public class CheckDataContacts {

    public interface ICheckDataView extends IBaseView {

    }


    public interface ICheckDataPresenter extends IBasePresenter {
        public List<String> getItemSpinnerData();

        public List<String> getMemberSpinnerData();

    }

    public interface ICheakDataModel {
        public List<String> itemSpinnerData();

        public List<String> memberSpinnerData();
    }

}
