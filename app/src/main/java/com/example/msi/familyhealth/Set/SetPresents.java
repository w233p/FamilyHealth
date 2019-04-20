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

    @Override
    public void addMemberClick(String memberName, String phone) {
        if (setModel.addMember(memberName, phone)) {
            getView().showToast("添加成功！");
        }
    }

    @Override
    public String[] getMemberList() {
        return setModel.getMember();
    }

    @Override
    public String getPhoneNumber(int position) {
        return setModel.phoneNumber(position);
    }
}
