package com.example.msi.familyhealth.MyData;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.msi.familyhealth.Data.BaseItemBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.Data.DbMemberMessageBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComContacts;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComModel;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComPresenter;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_auto;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_commen;
import com.example.msi.familyhealth.MyData.DataFragment.MyFragmentPagerAdapter;
import com.example.msi.familyhealth.View.TitleView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

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
//        buildBaseBean();
    }

    private void buildBaseBean() {
        BaseItemBean baseItemBean = new BaseItemBean().setAge(0).setHeight(0).setWeight(0);
        if (temporaryData[0] != null && temporaryData[1] != null && temporaryData[2] != null) {
            baseItemBean = new BaseItemBean().setAge(getInt(3)).setHeight(getInt(4)).setWeight(getFloat(5));
        }
    }

    private void saveToDataBase(){
/*删除之后id不变*/
        DataSupport.deleteAll(DbMemberMessageBean.class);
        DataSupport.deleteAll(DbMemberBean.class);

/*总算明白了，互相有变量才能关联，添加其中一个时两边都能关联上*/
        DbMemberMessageBean memberMessageBean = new DbMemberMessageBean().setAge(getInt(0)).setHeight(getInt(1)).setWeight(getFloat(2));
//        List<DbMemberBean>  dbMemberBean2 = DataSupport.where("memberName = ?","王易培").find(DbMemberBean.class);
//        DbMemberBean dbMemberBean1 = DataSupport.find(DbMemberBean.class,1);
//        memberMessageBean.setDbMemberBean(dbMemberBean1);
        if (memberMessageBean.save()){
            showToast("储存成功");
        }else{
            showToast("储存失败");
        }

        DbMemberBean dbMemberBean = new DbMemberBean().setMemberName("王易培").setMemberTelephone("13629714107");
        dbMemberBean.setDbMemberMessageBean(memberMessageBean);
        if (dbMemberBean.save()){
            showToast("人物储存成功");
        }else{
            showToast("人物储存失败");
        }


        /*添加关联，本次储存的数据关联上人物的信息
        * 先用名字查找到人物的项
        * 再添加此次数据
        * update给找到的人物，作为该人物的关联信息
        * 因为人名是唯一数据，所以找到后直接获取列表第一项的id*/
//        List<DbMemberBean>  dbMemberBean2 = DataSupport.where("memberName = ?","王易培").find(DbMemberBean.class);
//        DbMemberBean dbMemberBean1 = new DbMemberBean();
//        dbMemberBean1.setDbMemberMessageBean(memberMessageBean);
//        dbMemberBean1.setMemberName("wyp2");
////        dbMemberBean1.update(dbMemberBean2.get(0).getId());
//        dbMemberBean1.save();
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
        for (DbMemberMessageBean attribute:dbMemberMessageBeanList){
            Log.e("dbmmBean",String.valueOf(attribute.getAge()));
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
