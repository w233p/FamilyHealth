package com.example.msi.familyhealth.Set;


import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.model.OnTraceListener;
import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

import java.util.List;

public class SetContacts {
    public interface ISetView extends IBaseView {

    }

    public interface ISetPresenter extends IBasePresenter {
        List<String> getSetListDataItem();

        void addMemberClick(String memberName, String phone);

        String[] getMemberList();

        String getPhoneNumber(int position);

        void initTrace();

//        OnTraceListener getmTraceListener();
//
//        LBSTraceClient getmTraceClient();

        void traceStart();

        void traceStop();
    }

    public interface ISetModel {
        List<String> initSetListDataItem();

        boolean addMember(String memberName, String phone);

        String[] getMember();

        String phoneNumber(int position);
    }
}
