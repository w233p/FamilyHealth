package com.example.msi.familyhealth.CheckData;

import com.example.msi.familyhealth.Clock.ClockModel;
import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.github.mikephil.charting.charts.LineChart;

import java.util.List;

public class CheckDataPresenter extends BasePresenter<CheckDataContacts.ICheckDataView> implements CheckDataContacts.ICheckDataPresenter {

    CheckDataModel checkDataModel = new CheckDataModel();

    public CheckDataPresenter(CheckDataContacts.ICheckDataView view) {
        super(view);
    }

    @Override
    public List<String> getItemSpinnerData() {
        return checkDataModel.itemSpinnerData();
    }

    @Override
    public List<String> getMemberSpinnerData() {
        return checkDataModel.memberSpinnerData();
    }

    @Override
    public void showChart( LineChart mLineChart) {
        checkDataModel.setChartData(mLineChart);
    }

    @Override
    public void itemSelected(int position) {
        checkDataModel.changeChartName(position);
    }

    public void changeChartData(int memberPositon,int itemPositon){

    }
}
