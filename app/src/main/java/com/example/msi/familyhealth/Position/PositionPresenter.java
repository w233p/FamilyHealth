package com.example.msi.familyhealth.Position;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;


import com.example.msi.familyhealth.MvpBase.BasePresenter;

public class PositionPresenter extends BasePresenter<PositionContacts.IPositionView> implements PositionContacts.IPositionPresenter {
    private static final int BAIDU_READ_PHONE_STATE = 100;
    private static final int BAIDU_ACCESS_COARSE_LOCATION = 200;
    private static final int BAIDU_ACCESS_FINE_LOCATION = 300;
    private static final int BAIDU_READ_EXTERNAL_STORAGE = 400;
    private static final int BAIDU_WRITE_EXTERNAL_STORAGE = 500;

    public PositionPresenter(PositionContacts.IPositionView view) {
        super(view);
    }

    @Override
    public void getPermission(Context context) {

        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(getView().getSelfActivity(),
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // 返回值：
//                          如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                          如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                          如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                // 弹窗需要解释为何需要该权限，再次请求授权
                getView().showToast("使用电话需要授权");

                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                context.startActivity(intent);
            } else {
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(getView().getSelfActivity(),
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        BAIDU_ACCESS_COARSE_LOCATION);
            }
        }

        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(getView().getSelfActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // 返回值：
//                          如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                          如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                          如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                // 弹窗需要解释为何需要该权限，再次请求授权
                getView().showToast("使用电话需要授权");

                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                context.startActivity(intent);
            } else {
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(getView().getSelfActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        BAIDU_ACCESS_FINE_LOCATION);
            }
        }

        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(getView().getSelfActivity(),
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // 返回值：
//                          如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                          如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                          如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                // 弹窗需要解释为何需要该权限，再次请求授权
                getView().showToast("使用电话需要授权");

                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                context.startActivity(intent);
            } else {
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(getView().getSelfActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        BAIDU_READ_EXTERNAL_STORAGE);
            }
        }

        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 没有获得授权，申请授权
            if (ActivityCompat.shouldShowRequestPermissionRationale(getView().getSelfActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // 返回值：
//                          如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
//                          如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
//                          如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                // 弹窗需要解释为何需要该权限，再次请求授权
                getView().showToast("使用电话需要授权");

                // 帮跳转到该应用的设置界面，让用户手动授权
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                context.startActivity(intent);
            } else {
                // 不需要解释为何需要该权限，直接请求授权
                ActivityCompat.requestPermissions(getView().getSelfActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        BAIDU_WRITE_EXTERNAL_STORAGE);
            }
        }
    }
}
