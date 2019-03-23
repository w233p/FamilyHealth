package com.example.msi.familyhealth.MvpBase;
//public class BaseXPresenter<V extends IBaseXView> implements IBaseXPresenter {

import java.lang.ref.WeakReference;

public class BaseXFragPresenter<F extends IBaseXFrag> implements IBaseXPresenter {
    /*弱引用，防止内存泄漏*/
    private WeakReference<F> mFragRef;

    public BaseXFragPresenter(F frag) {
        attachView(frag);
    }

    private void attachView(F frag) {
        mFragRef = new WeakReference<F>(frag);
    }

    public F getView() {
        return mFragRef.get();
    }

    @Override
    public boolean isViewAttach() {
        return mFragRef != null && mFragRef.get() != null;
    }

    @Override
    public void detachView() {
        if (mFragRef != null) {
            mFragRef.clear();
            mFragRef = null;
        }
    }
}
