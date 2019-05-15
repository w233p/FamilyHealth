package com.example.msi.familyhealth.MvpBase;

import android.content.DialogInterface;

/**
 * view的接口
 */
public interface IBaseView extends IBaseXView {
    /**
     * findId
     */
    void initView();

    /**
     * 监听事件
     */
    void addListener();

    /**
     * 显示dialog
     */
//    void showDialog(String positiveMsg, String negativeMsg, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener);

    void showDialog();

    /**
     * 显示toast
     *
     * @param msg
     */
    void showToast(String msg);
}
