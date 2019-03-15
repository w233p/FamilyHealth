package com.example.msi.familyhealth.MvpBase;

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
    void showDialog();

    /**
     * 显示toast
     *
     * @param msg
     */
    void showToast(String msg);
}
