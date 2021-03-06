package com.example.msi.familyhealth.Clock;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.msi.familyhealth.Data.DbClockBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.ExitApplication;
import com.example.msi.familyhealth.View.MainListAdapter;
import com.example.msi.familyhealth.View.OneListView;
import com.example.msi.familyhealth.View.TitleView;
import com.example.msi.familyhealth.View.ViewHolder;

import org.litepal.crud.DataSupport;

import java.util.List;

import android.widget.AdapterView.*;
import android.app.*;
import android.content.*;

//public class CheckDataActivity extends BaseActivity<CheckDataContacts.ICheckDataPresenter> implements CheckDataContacts.ICheckDataView {
public class ClockActivity extends BaseActivity<ClockContacts.IClockPresenter> implements ClockContacts.IClockView {
    private Button addBt;
    private TitleView clockTitleView;
    private OneListView clockListView;
    private MainListAdapter clockListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_layout);
        ExitApplication.getInstance().addActivity(this);

        initView();

        addListener();

        setClockListAdapter();

    }

    @Override
    public ClockContacts.IClockPresenter onBindPresenter() {
        return new ClockPresenter(this);
    }

    @Override
    public void initView() {
        /*设置Button的样式*/
        addBt = (Button) findViewById(R.id.clock_add);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10);
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(getResources().getColor(R.color.c2));
        addBt.setBackground(gradientDrawable);

        clockTitleView = (TitleView) findViewById(R.id.clock_titleView);

        clockListView = (OneListView) findViewById(R.id.clock_listview);

//        testInitData();
    }

    private void testInitData() {
        if (DataSupport.findAll(DbClockBean.class).size() == 0) {
            List<DbMemberBean> dbMemberBeanList;

            if (DataSupport.where("membername = ?", "wyp").find(DbMemberBean.class) != null) {
                //模拟器上测试用
                dbMemberBeanList = DataSupport.where("membername = ?", "wyp").find(DbMemberBean.class);
            } else {
                //真机测试用
                dbMemberBeanList = DataSupport.where("membername = ?", "自己").find(DbMemberBean.class);
            }

//        List<DbClockBean> dbClockBeanList = DataSupport.findAll(DbClockBean.class);
//        for (int i = 0; i < dbClockBeanList.size(); i++) {
//            dbClockBeanList.get(i).delete();
//        }

            DbClockBean dbClockBean = new DbClockBean()
                    .setType(0)
                    .setHour(1)
                    .setMinute(11)
                    .setMedOrEventName("test1")
                    .setDbMemberBean(dbMemberBeanList.get(0));

            DbClockBean dbClockBean1 = new DbClockBean()
                    .setType(1)
                    .setHour(2)
                    .setMinute(22)
                    .setMedOrEventName("test2")
                    .setDbMemberBean(dbMemberBeanList.get(0));

            dbClockBean.save();
            dbClockBean1.save();
        }
    }

    /**
     * 给list添加adapter，传入list
     * list中存储类型，根据list的值，改变布局类型
     */
    public void setClockListAdapter() {
//留个坑，adapter好像可以同时传多个列表进去
        clockListAdapter = new MainListAdapter(this, getPresenter().initTypeList()) {
            @Override
            public void convert(ViewHolder viewHolder, String item) {

                Log.e("initclockdata", "1");
                switch (getTpye()) {
                    case 0:
                        getPresenter().initClockData(viewHolder);
                        setMedViewHolder(viewHolder);
                        break;
                    case 1:
                        getPresenter().initClockData(viewHolder);
                        setEventViewHolder(viewHolder);
                        break;
                }
            }
        };
        clockListView.setAdapter(clockListAdapter);

        clockListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {
                //Do something
                //AdapterView parent, View view, int position, long id)
                Log.e("longClickListener", String.valueOf(arg2) + String.valueOf(arg3));

                AlertDialog.Builder builder = new AlertDialog.Builder(ClockActivity.this);
                builder.setMessage("deleteClock?");
                builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().itemLongClick(ClockActivity.this, arg2);
                        getPresenter().memberSelect(getPresenter().getCurrentMemberPosition());
                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();
                return true;
            }
        });

        clockListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {
                showToast("xiugai");
            }
        });
    }

    public void setMedViewHolder(ViewHolder viewHolder) {
        viewHolder.setTextList(R.id.clock_medTv)
                .setTimeList(R.id.clock_med_timeTv);
    }

    public void setEventViewHolder(ViewHolder viewHolder) {
        viewHolder.setTextList(R.id.clock_eventTv)
                .setTimeList(R.id.clock_event_timeTv);
    }

    public void refreshClockListAdapter() {
        if (clockListAdapter != null) {
            clockListAdapter.notifyDataSetChanged();
            clockListView.startAnimation(at_animation());
        }
    }

    @Override
    public void addListener() {
        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClockActivity.this, ClockAddActivity.class);
                startActivity(intent);
                finish();
            }
        });

        clockTitleView.setBackBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (getPresenter().initTitleMemberSp() != null) {
            clockTitleView.setRightSpinnerAdapter(this, getPresenter().initTitleMemberSp());
            clockTitleView.setRightSpinnerOnItemSelectListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    getPresenter().memberSelect(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public Animation at_animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_translate_x);
        return animation;
    }
}
