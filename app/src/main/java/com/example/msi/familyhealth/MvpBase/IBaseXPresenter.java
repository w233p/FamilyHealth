package com.example.msi.familyhealth.MvpBase;

/**
 * Presenter的接口基类
 */
public interface IBaseXPresenter {

    /**
     * 判断presenter是否与view建立联系，防止内存泄漏
     * @return {@code true}:联系建立{@code false}:联系未建立
     */
    boolean isViewAttach();


    /**
     * 断开联系
     * */
    void detachView();
}
