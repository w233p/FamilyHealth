package com.example.msi.familyhealth.MyData;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.msi.familyhealth.CheckData.CheckDataActivity;
import com.example.msi.familyhealth.Data.DbDailyDataBean;
import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.Data.DbMemberMessageBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.MvpBase.BaseFragment;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComContacts;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_auto;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_commen;
import com.example.msi.familyhealth.MyData.DataFragment.MyFragmentPagerAdapter;
import com.example.msi.familyhealth.View.ExitApplication;
import com.example.msi.familyhealth.View.TitleView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDataActivity extends BaseActivity<MyDataContacts.IMyDataPresenter> implements MyDataContacts.IMyDataView {

    private TitleView titleView;
    private ViewPager viewPager;
    private List<BaseFragment<FragmentComContacts.IFragmentPresenter>> fragmentList;
    private RadioButton commenBt;
    private RadioButton autoBt;
    private TextView projectTv;
    private Fragment_commen fragment_commen;

    /**
     * 数据上传界面
     * 使用viewpager嵌套fragment
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.data_layout);
        ExitApplication.getInstance().addActivity(this);

//        getPresenter().getMyDataModel().initItemDataBase();

        /*初始化view的控件*/
        initView();

        /*设置监听器*/
        addListener();

        /*数组临时储存数据，因为值是利用textChangeListener得到，所以每一次EditText更改就会更新这个数组*/
        initData();

        //配置适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), setFragment()));

    }

    /**
     * 建立临时储存数据的数组
     */
    @Override
    public void initData() {
        getPresenter().initTemporaryData();
    }

    /**
     * 向表中添加Fragment
     */
    private List<BaseFragment<FragmentComContacts.IFragmentPresenter>> setFragment() {
        fragmentList = new ArrayList<BaseFragment<FragmentComContacts.IFragmentPresenter>>();

        fragment_commen = new Fragment_commen();
        fragmentList.add(fragment_commen);
        fragmentList.add(new Fragment_auto());
        return fragmentList;
    }

    /**
     * 测试数据库存入时间
     */
    private void initTimeTest() {
        Date date = new Date();
        long dateTime = date.getTime();
        DbDailyDataBean dbDailyDataBean = new DbDailyDataBean().setTime(dateTime).setDbItemBean(DataSupport.find(DbItemBean.class, 1)).setData(666).setDbMemberBean(DataSupport.find(DbMemberBean.class, 6));
        dbDailyDataBean.save();
    }

    /**
     * 保存数据到数据库
     */
    private void saveToDataBase() {

        getPresenter().initItemDataBase();//初始化项目数据

//        initTimeTest();//时间测试

        /*删除之后id不会重置*/
//        DataSupport.deleteAll(DbMemberMessageBean.class);
//        DataSupport.deleteAll(DbMemberBean.class);

        /*总算明白了，互相有变量才能关联，添加其中一个时两边都能关联上*/
        getPresenter().writeDb(fragmentList.get(0));
    }

    /**
     * log测试代码
     */
    private void test() {
        List<DbMemberMessageBean> dbMemberMessageBeanList = DataSupport.findAll(DbMemberMessageBean.class);
        for (DbMemberMessageBean attribute : dbMemberMessageBeanList) {
            Log.e("dbmmBean", String.valueOf(attribute.getAge()));
        }
    }


    @Override
    public void initView() {
        titleView = (TitleView) findViewById(R.id.data_titleView);
        viewPager = (ViewPager) findViewById(R.id.data_vp);
        commenBt = (RadioButton) findViewById(R.id.up_common_rb);
        autoBt = (RadioButton) findViewById(R.id.up_auto_rb);

        View view = getLayoutInflater().inflate(R.layout.fragment_commen, null);
        View view1 = (View) view.findViewById(R.id.list_sp_text1);
        projectTv = (TextView) view1.findViewById(R.id.list_sp_text);
    }

    @Override
    public void addListener() {
        /*确定按钮，点击保存数据*/
        titleView.setConfirmBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDataBase();
//                test();
                showToast("添加成功");
                Intent intent = new Intent(MyDataActivity.this, CheckDataActivity.class);
                startActivity(intent);
            }
        });

        /*返回按钮，点击关闭此界面*/
        titleView.setBackBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

    @Override
    public MyDataContacts.IMyDataPresenter onBindPresenter() {
        return new MyDataPresenter(this);
    }
}
