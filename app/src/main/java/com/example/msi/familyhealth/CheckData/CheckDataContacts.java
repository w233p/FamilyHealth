package com.example.msi.familyhealth.CheckData;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;
import com.github.mikephil.charting.charts.LineChart;

import java.util.List;

public class CheckDataContacts {

    public interface ICheckDataView extends IBaseView {

    }


    public interface ICheckDataPresenter extends IBasePresenter {
        public List<String> getItemSpinnerData();

        public List<String> getMemberSpinnerData();

        public void showChart(LineChart mLineChart);

        public void itemSelected(int position);

        public void changeChartData(int memberPositon,int itemPositon);

    }

    public interface ICheakDataModel {
        public List<String> itemSpinnerData();

        public List<String> memberSpinnerData();

        public void setChartData(LineChart mLineChart);

        public void changeChartName(int position);

        public void changeChartData(int memberPositon,int itemPositon);
    }

}
