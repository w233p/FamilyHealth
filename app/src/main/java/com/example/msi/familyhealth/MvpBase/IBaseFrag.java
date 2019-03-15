package com.example.msi.familyhealth.MvpBase;

/**
 * Fragment的接口
 */
public interface IBaseFrag extends IBaseXFrag {
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
