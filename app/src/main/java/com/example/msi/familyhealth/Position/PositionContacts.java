package com.example.msi.familyhealth.Position;

import android.content.Context;

import com.example.msi.familyhealth.MvpBase.IBasePresenter;
import com.example.msi.familyhealth.MvpBase.IBaseView;

public class PositionContacts {
    public interface IPositionView extends IBaseView {

    }

    public interface IPositionPresenter extends IBasePresenter {
        void getPermission(Context context);

//        void showTrace();
    }

    public interface IPositionModel {

    }
}
