package com.example.msi.familyhealth.MvpBase;

import android.app.Activity;

/**
 * view的接口基类
 * 在此处获取activity对象，避免在presenter中创建context，防止内存泄漏
 */
public interface IBaseXView {
    /*
    *获取Activity对象
    * */
    <T extends Activity> T getSelfActivity();
}
