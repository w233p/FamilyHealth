package com.example.msi.familyhealth.MvpBase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import org.litepal.LitePal;

public abstract class BaseActivity<P extends IBasePresenter> extends BaseXActivity<P> implements IBaseView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.initialize(this);
    }

//    /**
//     * 显示dialog
//     */
//    @Override
//    public void showDialog(String positiveMsg, String negativeMsg, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener) {
//        AlertDialog.Builder builder = new AlertDialog().Builder(this);
//        builder.setPositiveButton(positiveMsg, positiveListener);
//        builder.setNegativeButton(negativeMsg, negativeListener);
//    }

    @Override
    public void showDialog() {

    }

    /**
     * 显示toast
     *
     * @param msg
     */
    @Override
    public void showToast(String msg) {
        Toast.makeText(getSelfActivity(), msg, Toast.LENGTH_LONG).show();
    }
}
