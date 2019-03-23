package com.example.msi.familyhealth.MyData;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.msi.familyhealth.Data.BaseItemBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComContacts;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComModel;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComPresenter;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_auto;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_commen;
import com.example.msi.familyhealth.MyData.DataFragment.MyFragmentPagerAdapter;
import com.example.msi.familyhealth.View.TitleView;

import java.util.ArrayList;
import java.util.List;

public class MyDataActivity extends BaseActivity<MyDataContacts.IMyDataPresenter> implements MyDataContacts.IMyDataView {

    private TitleView titleView;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private RadioButton commenBt;
    private RadioButton autoBt;
    private String[] temporaryData;


    /**
     * 数据上传界面
     * 使用viewpager嵌套fragment
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.data_layout);

        titleView = (TitleView) findViewById(R.id.data_titleView);
        viewPager = (ViewPager) findViewById(R.id.data_vp);
        commenBt = (RadioButton) findViewById(R.id.up_common_rb);
        autoBt = (RadioButton) findViewById(R.id.up_auto_rb);
        temporaryData = new String[10];

        initTemporaryData();

        titleView.setConfirmBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("titlee", "click");
            }
        });


        //配置适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), setFragment()));

        //点击切换Fragment
        commenBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        autoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });


        /**
         * @param position 当前显示的viewpager的position
         * viewpager切换监听
         */
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    commenBt.setChecked(true);
                } else if (position == 1) {
                    autoBt.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    /**
     * 向表中添加Fragment
     */
    private List<Fragment> setFragment() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Fragment_commen());
        fragmentList.add(new Fragment_auto());
        return fragmentList;
    }

    private void initTemporaryData() {
        for (int i = 0; i < 10; i++) {
            temporaryData[i] = "0";
        }
    }

    public void getEditText(int position, String str) {
        Toast.makeText(this, str + "---" + position, Toast.LENGTH_SHORT).show();
        saveData(position, str);
    }

    private void saveData(int position, String str) {
        switch (FragmentComModel.getList().get(1)) {
            case "项目":
                saveBaseData(position, str);
                break;
        }
    }

    private void saveBaseData(int position, String str) {
        Log.e("判断", "项目");
        //存入临时数组中
        temporaryData[position] = str;
        for (int i = 0; i < 10; i++) {
//            Log.e("data", position + "::" + temporaryData[i]);
        }
        buildBaseBean();
    }

    private void buildBaseBean() {
//        BaseItemBean baseItemBean = new BaseItemBean().setAge(0).setHeight(0).setWeight(0);
        if (temporaryData[3] != null && temporaryData[4] != null && temporaryData[5] != null) {
            BaseItemBean baseItemBean = new BaseItemBean().setAge(getInt(3)).setHeight(getInt(4)).setWeight(getFloat(5));
            test(baseItemBean);
        }

    }

    private int getInt(int dataPosition) {
        int in = Integer.valueOf(temporaryData[dataPosition]);
        return in;
    }

    private float getFloat(int dataPosition) {
        float fl = Float.valueOf(temporaryData[dataPosition]);
        return fl;
    }

    private void test(BaseItemBean baseItemBean) {
        Log.e("age", "" + baseItemBean.getAge());
        Log.e("shengao", "" + baseItemBean.getHeight());
        Log.e("tizhogn", "" + baseItemBean.getWeight());

    }


    @Override
    public void initView() {

    }

    @Override
    public void addListener() {

    }

    @Override
    public MyDataContacts.IMyDataPresenter onBindPresenter() {
        return new MyDataPresenter(this);
    }
}
