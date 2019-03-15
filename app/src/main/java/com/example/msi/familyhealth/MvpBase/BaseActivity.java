package com.example.msi.familyhealth.MvpBase;

import android.widget.Toast;

public abstract class BaseActivity<P extends IBasePresenter> extends BaseXActivity<P> implements IBaseView {


    /**
     * 显示dialog
     */
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
