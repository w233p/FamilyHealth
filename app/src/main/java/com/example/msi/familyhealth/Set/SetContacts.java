package com.example.msi.familyhealth.Set;


import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

import java.util.List;

public class SetContacts {
    public interface ISetView extends IBaseView {

    }

    public interface ISetPresenter extends IBasePresenter {
        public List<String> getSetListDataItem();
    }

    public interface ISetModel {
        public List<String> initSetListDataItem();


    }
}
