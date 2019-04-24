package com.example.msi.familyhealth.CheckData;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;
import com.github.mikephil.charting.data.LineData;

import java.util.List;

public class CheckDataContacts {

    public interface ICheckDataView extends IBaseView {
        void showChart(LineData data);

        void setAnalysisText(String msg);
    }


    public interface ICheckDataPresenter extends IBasePresenter {
        List<String> getItemSpinnerData();

        List<String> getMemberSpinnerData();

        void initChart(int memberPosition, int itemPosition);

        void itemSelected(int position);

        void memberSelected(int memberPositon, int itemPositon);

        void changeChartData(int memberPositon, int itemPositon);

        void chooseTimeclick(int time);

    }

    public interface ICheakDataModel {
        List<String> itemSpinnerData();

        List<String> memberSpinnerData();

        LineData setChartData(int memberPosition, int itemPosition);

        LineData changeChartName(int position);

        LineData changeChartData(int memberPositon, int itemPositon);
    }

}
