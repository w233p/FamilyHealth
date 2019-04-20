package com.example.msi.familyhealth.HealthTips;

import android.content.Context;
import android.widget.ListView;

import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.HealthTipListViewAdapter;
import com.example.msi.familyhealth.View.MyListViewAdapter;
import com.example.msi.familyhealth.View.ViewHolder;

public class HealthTipsPresenter extends BasePresenter<HealthTipsContacts.IHealthTipView> implements HealthTipsContacts.IHealthTipPresenter {
    HealthTipsModel healthTipsModel = new HealthTipsModel();

    public HealthTipsPresenter(HealthTipsContacts.IHealthTipView view) {
        super(view);
    }

    @Override
    public void listSetAdapter(Context context, ListView tipListView) {
        tipListView.setAdapter(new HealthTipListViewAdapter(context,healthTipsModel.initTipData()) {
            @Override
            public void convert(ViewHolder viewHolder, String item) {
                viewHolder.setText(R.id.health_tip_text,item);
            }
        });
    }
}
