package com.example.msi.familyhealth.MyData.DataFragment;

import android.util.Log;

import com.example.msi.familyhealth.MvpBase.BaseFragPresenter;
import com.example.msi.familyhealth.MvpBase.BasePresenter;

import java.util.List;

public class FragmentComPresenter extends BaseFragPresenter<FragmentComContacts.IFragmentView> implements FragmentComContacts.IFragmentPresenter {


    FragmentComModel fragmentComModel = new FragmentComModel();

    public FragmentComModel getFragmentComModel() {
        return fragmentComModel;
    }

    public void setFragmentComModel(FragmentComModel fragmentComModel) {
        this.fragmentComModel = fragmentComModel;
    }

    public FragmentComPresenter(FragmentComContacts.IFragmentView view) {
        super(view);
    }

    @Override
    public void createList() {
        fragmentComModel.initSpinnerList();
        fragmentComModel.initMemberList();
        fragmentComModel.initList();
    }

    @Override
    public void projectSelect(String projects) {
        fragmentComModel.setProjectSpText(projects);
        Log.e("presenter","projectSelect");
//        fragmentComModel.initTypeList();
        fragmentComModel.refreshList();
    }

    @Override
    public void memberSelect(String member) {
        fragmentComModel.setMemberSpText(member);
    }

}
