package com.example.msi.familyhealth.CheckData;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;

import java.util.List;

public class CheckDataContacts {

    public interface ICheckDataView extends IBaseView {
        void showChart(LineData data);
    }


    public interface ICheckDataPresenter extends IBasePresenter {
        public List<String> getItemSpinnerData();

        public List<String> getMemberSpinnerData();

        public void initChart( int memberPosition, int itemPosition);

        public void itemSelected(int position);

        public void memberSelected(int memberPositon, int itemPositon);

        public void changeChartData(int memberPositon, int itemPositon);


    }

    public interface ICheakDataModel {
        public List<String> itemSpinnerData();

        public List<String> memberSpinnerData();

        public LineData setChartData(int memberPosition, int itemPosition);

        public LineData changeChartName(int position);

        public LineData changeChartData(int memberPositon, int itemPositon);
    }

}
