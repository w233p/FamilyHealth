package com.example.msi.familyhealth.MyData;

import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.DataFragment.Fragment_auto;
import com.example.msi.familyhealth.View.DataFragment.Fragment_commen;
import com.example.msi.familyhealth.View.DataFragment.MyFragmentPagerAdapter;
import com.example.msi.familyhealth.View.MyListViewAdapter;
import com.example.msi.familyhealth.View.TitleView;
import com.example.msi.familyhealth.View.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MyDataActivity extends AppCompatActivity {

    private TitleView titleView;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private RadioButton commenBt;
    private RadioButton autoBt;
//    private ListView listView;
//    private List<String> list;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.data_layout);

        titleView = (TitleView) findViewById(R.id.data_titleView);
        viewPager = (ViewPager) findViewById(R.id.data_vp);
        commenBt = (RadioButton) findViewById(R.id.up_common_rb);
        autoBt = (RadioButton) findViewById(R.id.up_auto_rb);
//        listView = (ListView) findViewById(R.id.up_data_list);
//
//        initList();
//
//        listView.setAdapter(new MyListViewAdapter<String>(list,R.layout.list_item_text) {
//            @Override
//            public void convert(ViewHolder viewHolder, String item) {
//                viewHolder.setText(R.id.list_text,"test");
//            }
//        });

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
                if(position == 0){
                    commenBt.setChecked(true);
                }else if (position == 1){
                    autoBt.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

//    private void initList() {
//        list = new ArrayList<>();
//        for (int i =0 ;i<5;i++){
//            list.add("测试"+i);
//        }
//    }


    /**
     * 向表中添加Fragment
     */
    private List<Fragment> setFragment() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Fragment_commen());
        fragmentList.add(new Fragment_auto());
        return fragmentList;
    }
}
