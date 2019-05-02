package com.example.msi.familyhealth.CheckData;

import com.example.msi.familyhealth.MvpBase.BasePresenter;

import java.util.List;
//论文选题提纲思路，模块实现调试
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
    public void initChart(int memberPosition, int itemPosition) {
        getView().showChart(checkDataModel.setChartData(memberPosition, itemPosition));
    }

    @Override
    public void itemSelected(int position) {
//        checkDataModel.changeChartName(position);
        getView().showChart(checkDataModel.changeChartName(position));
    }

    @Override
    public void memberSelected(int memberPositon, int itemPositon) {
        getView().showChart(checkDataModel.changeChartData(memberPositon, itemPositon));
    }

    @Override
    public void changeChartData(int memberPositon, int itemPositon) {
        getView().showChart(checkDataModel.setChartData(memberPositon, itemPositon));
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
}
