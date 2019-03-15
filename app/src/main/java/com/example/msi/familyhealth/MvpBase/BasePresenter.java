package com.example.msi.familyhealth.MvpBase;

public abstract class BasePresenter<V extends IBaseView> extends BaseXPresenter<V> implements IBasePresenter {
    public BasePresenter(V view) {
        super(view);
    }
}
