package com.example.msi.familyhealth.MvpBase;
//public abstract class BasePresenter<V extends IBaseView> extends BaseXPresenter<V> implements IBasePresenter {

public abstract class BaseFragPresenter<F extends IBaseFrag> extends BaseXFragPresenter<F> implements IBaseXPresenter {
    public BaseFragPresenter(F view) {
        super(view);
    }
}
