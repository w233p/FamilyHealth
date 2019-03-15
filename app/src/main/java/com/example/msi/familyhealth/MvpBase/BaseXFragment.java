package com.example.msi.familyhealth.MvpBase;

import android.app.Activity;
import android.support.v4.app.Fragment;

public abstract class BaseXFragment<P extends IBaseXPresenter> extends Fragment implements IBaseXFrag {

    private P mPresenter;

    /**
     * 创建Presenter
     */
    public abstract P onBindPresenter();

    /**
     * 获取presenter对象
     */
    public P getPresenter() {
        if (mPresenter == null) {
            mPresenter = onBindPresenter();
        }
        return mPresenter;
    }


    @Override
    public Fragment getSelfFragment() {
        return this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /*断开presenter与view联系防止内存泄漏*/
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
