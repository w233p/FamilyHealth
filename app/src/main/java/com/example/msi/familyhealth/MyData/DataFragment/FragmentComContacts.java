package com.example.msi.familyhealth.MyData.DataFragment;


import android.view.View;

import com.example.msi.familyhealth.MvpBase.IBaseFrag;
import com.example.msi.familyhealth.MvpBase.IBasePresenter;


public class FragmentComContacts {
    public interface IFragmentView extends IBaseFrag {
        @Override
        void addListener();


        void initView(View view);
    }

    public interface IFragmentPresenter extends IBasePresenter {

        void createList();

        void memberSelect();

        void projectSelect(String project);

        void setFragmentComModel(FragmentComModel fragmentComModel);

        FragmentComModel getFragmentComModel();

    }

    public interface IFragmentModel {
        void initList();

    }
}
