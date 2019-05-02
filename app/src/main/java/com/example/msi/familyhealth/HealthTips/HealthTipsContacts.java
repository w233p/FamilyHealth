package com.example.msi.familyhealth.HealthTips;

import android.content.Context;
import android.widget.ListView;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

import java.util.List;

public class HealthTipsContacts {
    public interface IHealthTipView extends IBaseView {
        void showTipDialog();
    }

    public interface IHealthTipPresenter extends IBasePresenter {
        void listSetAdapter(Context context, ListView tipListView);

        void showTip(int position);
    }

    public interface IHealthTipModel {
        List<String> initTipData();

        String getPositionData(int position);
    }
}
