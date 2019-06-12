package com.example.msi.familyhealth.CheckData;

import android.content.Context;
import android.util.Log;

import com.example.msi.familyhealth.MvpBase.BasePresenter;
import com.github.mikephil.charting.data.LineData;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

//论文选题提纲思路，模块实现调试
public class CheckDataPresenter extends BasePresenter<CheckDataContacts.ICheckDataView> implements CheckDataContacts.ICheckDataPresenter {

    private CheckDataModel checkDataModel = new CheckDataModel();

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
    public void initChart(int memberPosition, int itemPosition) {
        getView().showChart(checkDataModel.setChartData(memberPosition, itemPosition));
        Log.e("initchart","2");
    }

    @Override
    public void itemSelected(int position) {
        getView().showChart(checkDataModel.changeChartLabel(position));
    }

    @Override
    public void memberSelected(int memberPositon, int itemPositon) {
//        getView().showChart(checkDataModel.changeChartData(memberPositon, itemPositon));
        getView().showChart(checkDataModel.setChartData(memberPositon, itemPositon));
    }

    @Override
    public void changeChartData(int memberPositon, int itemPositon) {
        getView().showChart(checkDataModel.setChartData(memberPositon, itemPositon));
        Log.e("changechartdata","3");
        getView().setAnalysisText(checkDataModel.getResult());
    }

    @Override
    public void chooseTimeclick(int time) {
        switch (time) {
            case 1:
                checkDataModel.chartTime = checkDataModel.zero;
                break;
            case 2:
                checkDataModel.chartTime = checkDataModel.weekTime;
                break;
            case 3:
                checkDataModel.chartTime = checkDataModel.monthTime;
                break;
            case 4:
                checkDataModel.chartTime = checkDataModel.yearTime;
                break;
        }
    }

    @Override
    public void getDataFromServer() {
        checkDataModel.setChartDataByServer(this);

    }

    public void getDataFromServerDone(LineData data){
        getView().showChart(data);
    }
}
