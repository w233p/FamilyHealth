package com.example.msi.familyhealth.MvpBase;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public abstract class BaseFragment<P extends IBasePresenter> extends BaseXFragment<P> implements IBaseFrag {


    /**
     * findId
     */
    @Override
    public void initView() {

    }

    /**
     * 监听事件
     */
    @Override
    public void addListener() {

    }

}
