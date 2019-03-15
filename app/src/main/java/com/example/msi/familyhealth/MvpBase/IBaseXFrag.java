package com.example.msi.familyhealth.MvpBase;


import android.support.v4.app.Fragment;

/**
 * Fragment的接口基类
 */
public interface IBaseXFrag {
    /*
     *获取Fragment对象
     * */
    <T extends Fragment> T getSelfFragment();
}
