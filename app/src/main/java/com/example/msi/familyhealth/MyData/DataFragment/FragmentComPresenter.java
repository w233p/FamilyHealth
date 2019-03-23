package com.example.msi.familyhealth.MyData.DataFragment;

import com.example.msi.familyhealth.MvpBase.BaseFragPresenter;
import com.example.msi.familyhealth.MvpBase.BasePresenter;

public class FragmentComPresenter extends BaseFragPresenter<FragmentComContacts.IFragmentView> implements FragmentComContacts.IFragmentPresenter {

    FragmentComModel fragmentComModel = new FragmentComModel();

    public FragmentComPresenter(FragmentComContacts.IFragmentView view) {
        super(view);
    }

    @Override
    public void createList() {
        fragmentComModel.initList();
    }

}
