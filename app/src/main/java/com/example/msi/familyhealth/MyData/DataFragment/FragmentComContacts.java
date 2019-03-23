package com.example.msi.familyhealth.MyData.DataFragment;


import com.example.msi.familyhealth.MvpBase.IBaseFrag;
import com.example.msi.familyhealth.MvpBase.IBasePresenter;


public class FragmentComContacts {
    public interface IFragmentView extends IBaseFrag {
        @Override
        void addListener();

    }

    public interface IFragmentPresenter extends IBasePresenter {

        void createList();

    }

    public interface IFragmentModel {
        void initList();

    }
}
