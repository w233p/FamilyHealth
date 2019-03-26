package com.example.msi.familyhealth.MyData;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.msi.familyhealth.Data.DbDailyDataBean;
import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.Data.DbMemberMessageBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_auto;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_commen;
import com.example.msi.familyhealth.MyData.DataFragment.MyFragmentPagerAdapter;
import com.example.msi.familyhealth.View.TitleView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDataActivity extends BaseActivity<MyDataContacts.IMyDataPresenter> implements MyDataContacts.IMyDataView {

    private TitleView titleView;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private RadioButton commenBt;
    private RadioButton autoBt;
    private String[] temporaryData;
    private TextView projectTv;


    /**
     * 数据上传界面
     * 使用viewpager嵌套fragment
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.data_layout);

        /*初始化view的控件*/
        initView();

        /*设置监听器*/
        addListener();

        /*数组临时储存数据，因为值是利用textChangeListener得到，所以每一次EditText更改就会更新这个数组*/
        initTemporaryData();

        //配置适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), setFragment()));

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
        Log.e("project", projectTv.getText() + "");
        if (true) {
            saveBaseData(position, str);
        }
    }

    private void saveBaseData(int position, String str) {
        Log.e("判断", "项目");
        //存入临时数组中
        temporaryData[position] = str;
        for (int i = 0; i < 10; i++) {
            Log.e("data", position + "::" + temporaryData[i]);
        }
    }

    /**
     * 临时初始化项目的数据库
     */
    private void initItemDataBase() {
        DbProjectBean dbProjectBean = new DbProjectBean().setProject("日常");
        dbProjectBean.save();
        DbProjectBean dbProjectBean1 = new DbProjectBean().setProject("血液");
        dbProjectBean1.save();
        DbProjectBean dbProjectBean2 = new DbProjectBean().setProject("尿检");
        dbProjectBean2.save();
        DbProjectBean dbProjectBean3 = new DbProjectBean().setProject("糖尿病");
        dbProjectBean3.save();
        DbProjectBean dbProjectBean4 = new DbProjectBean().setProject("基本信息");
        dbProjectBean4.save();

        DbItemBean dbItemBean = new DbItemBean().setItem("血糖");
        dbItemBean.setDbProjectBean(dbProjectBean).save();
        DbItemBean dbItemBean1 = new DbItemBean().setItem("血脂");
        dbItemBean1.setDbProjectBean(dbProjectBean).save();
        DbItemBean dbItemBean2 = new DbItemBean().setItem("血压");
        dbItemBean2.setDbProjectBean(dbProjectBean).save();
//        "甘油三酯", "胆固醇", "红细胞", "红细胞体积分布宽度", "白细胞", "血小板"
//            , "糖化血红蛋白", "心肌酶", "血尿酸"
        DbItemBean dbItemBean3 = new DbItemBean().setItem("甘油三酯");
        dbItemBean3.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean4 = new DbItemBean().setItem("胆固醇");
        dbItemBean4.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean5 = new DbItemBean().setItem("红细胞");
        dbItemBean5.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean6 = new DbItemBean().setItem("红细胞体积分布宽度");
        dbItemBean6.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean7 = new DbItemBean().setItem("白细胞");
        dbItemBean7.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean8 = new DbItemBean().setItem("血小板");
        dbItemBean8.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean9 = new DbItemBean().setItem("糖化血红蛋白");
        dbItemBean9.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean10 = new DbItemBean().setItem("心肌酶");
        dbItemBean10.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean11 = new DbItemBean().setItem("血尿酸");
        dbItemBean11.setDbProjectBean(dbProjectBean1).save();
//        {"PH", "蛋白质", "比重", "潜血", "微量白蛋白", "肌酐"};
        DbItemBean dbItemBean12 = new DbItemBean().setItem("PH");
        dbItemBean12.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean13 = new DbItemBean().setItem("蛋白质");
        dbItemBean13.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean14 = new DbItemBean().setItem("比重");
        dbItemBean14.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean15 = new DbItemBean().setItem("潜血");
        dbItemBean15.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean16 = new DbItemBean().setItem("微量白蛋白");
        dbItemBean16.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean17 = new DbItemBean().setItem("肌酐");
        dbItemBean17.setDbProjectBean(dbProjectBean2).save();
//        "胰岛素","ICA抗胰岛细胞抗体","GAD抗谷氨酸脱氢酶抗体","IAA抗胰岛素抗体"
        DbItemBean dbItemBean18 = new DbItemBean().setItem("胰岛素");
        dbItemBean18.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean19 = new DbItemBean().setItem("ICA抗胰岛细胞抗体");
        dbItemBean19.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean20 = new DbItemBean().setItem("GAD抗谷氨酸脱氢酶抗体");
        dbItemBean20.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean21 = new DbItemBean().setItem("IAA抗胰岛素抗体");
        dbItemBean21.setDbProjectBean(dbProjectBean2).save();

    }

    /**
     * 测试数据库存入时间
     */
    private void initTimeTest(){
        Date date = new Date();
        long dateTime = date.getTime();
        DbDailyDataBean dbDailyDataBean =new DbDailyDataBean().setTime(dateTime).setDbItemBean(DataSupport.find(DbItemBean.class,1)).setData(666).setDbMemberBean(DataSupport.find(DbMemberBean.class,6));
        dbDailyDataBean.save();
    }


    private void saveToDataBase() {

        initItemDataBase();//初始化项目数据
        initTimeTest();

        /*删除之后id不变*/
//        DataSupport.deleteAll(DbMemberMessageBean.class);
//        DataSupport.deleteAll(DbMemberBean.class);

        /*总算明白了，互相有变量才能关联，添加其中一个时两边都能关联上*/
//        DbMemberMessageBean memberMessageBean = new DbMemberMessageBean().setAge(getInt(0)).setHeight(getInt(1)).setWeight(getFloat(2));
////        List<DbMemberBean>  dbMemberBean2 = DataSupport.where("memberName = ?","王易培").find(DbMemberBean.class);
////        DbMemberBean dbMemberBean1 = DataSupport.find(DbMemberBean.class,1);
////        memberMessageBean.setDbMemberBean(dbMemberBean1);
//        if (memberMessageBean.save()){
//            showToast("储存成功");
//        }else{
//            showToast("储存失败");
//        }
//
//        DbMemberBean dbMemberBean = new DbMemberBean().setMemberName("wyp").setMemberTelephone("13629714107");
////        dbMemberBean.setDbMemberMessageBean(memberMessageBean);
//        if (dbMemberBean.save()){
//            showToast("人物储存成功");
//        }else{
//            showToast("人物储存失败");
//        }
//
//
//        /*添加关联，本次储存的数据关联上人物的信息
//        * 先用名字查找到人物的项
//        * 再添加此次数据
//        * update给找到的人物，作为该人物的关联信息
//        * 因为人名是唯一数据，所以找到后直接获取列表第一项的id*/
//        List<DbMemberBean>  dbMemberBean2 = DataSupport.where("memberName = ?","王易培").find(DbMemberBean.class);
//        DbMemberBean dbMemberBean1 = new DbMemberBean();
//        dbMemberBean1.setDbMemberMessageBean(memberMessageBean);
//        dbMemberBean1.setMemberName("wyp2");
//        dbMemberBean1.update(dbMemberBean2.get(0).getId());
////        dbMemberBean1.save();
//        Log.e("iid",String.valueOf(dbMemberBean2.get(0).getId()));

    }

    private int getInt(int dataPosition) {
        int in = Integer.valueOf(temporaryData[dataPosition]);
        return in;
    }

    private float getFloat(int dataPosition) {
        float fl = Float.valueOf(temporaryData[dataPosition]);
        return fl;
    }

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
        temporaryData = new String[10];

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
                test();
                Log.e("titlee", "click");
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
