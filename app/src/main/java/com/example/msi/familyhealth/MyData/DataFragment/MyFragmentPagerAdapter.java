package com.example.msi.familyhealth.MyData.DataFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.msi.familyhealth.MvpBase.BaseFragment;

import java.util.List;

/**
 * 数据上传界面
 * Fragment适配器
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment<FragmentComContacts.IFragmentPresenter>> fragmentList;

    public MyFragmentPagerAdapter(FragmentManager fm, List<BaseFragment<FragmentComContacts.IFragmentPresenter>> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
