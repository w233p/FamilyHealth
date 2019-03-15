package com.example.msi.familyhealth.MvpBase;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

/**
 * View的基类实现
 */
public abstract class BaseXActivity<P extends IBaseXPresenter> extends AppCompatActivity implements IBaseXView {

    private P mPresenter;

    /**
     * 创建Presenter
     */
    public abstract P onBindPresenter();


    /**
     *获取presenter对象
     */
    public P getPresenter() {
        if (mPresenter == null) {
            mPresenter = onBindPresenter();
        }
        return mPresenter;
    }



    @Override
    public Activity getSelfActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*断开presenter与view联系防止内存泄漏*/
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
