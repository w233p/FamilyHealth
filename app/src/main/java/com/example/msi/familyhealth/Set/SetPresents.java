package com.example.msi.familyhealth.Set;

import com.example.msi.familyhealth.MvpBase.*;

import java.util.List;

public class SetPresents extends BasePresenter<SetContacts.ISetView> implements SetContacts.ISetPresenter {
    SetModel setModel = new SetModel();

    public SetPresents(SetContacts.ISetView view) {
        super(view);
    }

    @Override
    public List<String> getSetListDataItem() {
        return setModel.initSetListDataItem();
    }

}
