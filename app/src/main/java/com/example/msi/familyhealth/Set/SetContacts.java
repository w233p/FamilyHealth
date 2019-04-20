package com.example.msi.familyhealth.Set;


import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

import java.util.List;

public class SetContacts {
    public interface ISetView extends IBaseView {

    }

    public interface ISetPresenter extends IBasePresenter {
        public List<String> getSetListDataItem();

        public void addMemberClick(String memberName, String phone);

        public String[] getMemberList();

        public String getPhoneNumber(int position);
    }

    public interface ISetModel {
        public List<String> initSetListDataItem();

        public boolean addMember(String memberName, String phone);

        public String[] getMember();

        public String phoneNumber(int position);
    }
}
