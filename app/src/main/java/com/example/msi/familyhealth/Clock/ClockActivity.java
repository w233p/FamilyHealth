package com.example.msi.familyhealth.Clock;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.msi.familyhealth.Data.DbClockBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.MainListAdapter;
import com.example.msi.familyhealth.View.TitleView;
import com.example.msi.familyhealth.View.ViewHolder;

import java.util.ArrayList;
import java.util.List;

//public class CheckDataActivity extends BaseActivity<CheckDataContacts.ICheckDataPresenter> implements CheckDataContacts.ICheckDataView {
public class ClockActivity extends BaseActivity<ClockContacts.IClockPresenter> implements ClockContacts.IClockView {
    private Button addBt;
    private TitleView clockTitleView;
    private TitleView clockAddTitleView;
    private ListView clockListView;
    private MainListAdapter clockListAdapter;

    private TextView addMember;
    private Spinner addMemberSp;
    private TextView addRepeat;
    private Spinner addRepeatSp;
    private TextView addType;
    private Spinner addTypeSp;
    private TextView addMsg;
    private EditText addMsgEd;
    private TimePicker addTimePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_layout);

        initView();

        addListener();

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
        gradientDrawable.setColor(getResources().getColor(R.color.loginYellow));
        addBt.setBackground(gradientDrawable);

        clockTitleView = (TitleView) findViewById(R.id.clock_titleView);

        clockListView = (ListView) findViewById(R.id.clock_listview);

        getPresenter().initList();

        testInitData();
    }

    private void testInitData() {
        for (int i = 0; i < 2; i++) {
            DbClockBean dbClockBean = new DbClockBean().setType(0);
            DbClockBean dbClockBean1 = new DbClockBean().setType(1);
            dbClockBean.save();
            dbClockBean1.save();
        }
    }

    /**
     * 给list添加adapter，传入list
     *             list中存储类型，根据list的值，改变布局类型
     */
    public void setClockListAdapter() {
        clockListAdapter = new MainListAdapter(this, getPresenter().initList()) {
            @Override
            public void convert(ViewHolder viewHolder, String item) {
                switch (getTpye()) {
                    case 0:
                        //getmeddata
                        viewHolder.setText(R.id.clock_medTv,item);
                        break;
                    case 1:
                        //geteventdata
                        viewHolder.setText(R.id.clock_eventTv,item);
                        break;
                }
            }
        };
        clockListView.setAdapter(clockListAdapter);
    }

    public void refreshClockListAdapter() {
        if (clockListAdapter != null) {
            clockListAdapter.notifyDataSetChanged();
            clockListView.startAnimation(at_animation());
        }
    }


    private void initAddView() {
        View view1 = (View) findViewById(R.id.clock_sp_text1);
        addMember = (TextView) view1.findViewById(R.id.list_sp_text);
        addMember.setText(R.string.family_member);
        addMemberSp = (Spinner) view1.findViewById(R.id.list_spinner);

        View view2 = (View) findViewById(R.id.clock_sp_text2);
        addRepeat = (TextView) view2.findViewById(R.id.list_sp_text);
        addRepeat.setText(R.string.repeat);
        addRepeatSp = (Spinner) view2.findViewById(R.id.list_spinner);

        View view3 = (View) findViewById(R.id.clock_sp_text3);
        addType = (TextView) view3.findViewById(R.id.list_sp_text);
        addType.setText(R.string.type);
        addTypeSp = (Spinner) view3.findViewById(R.id.list_spinner);

        View view4 = (View) findViewById(R.id.clock_ed_text);
        addMsg = (TextView) view4.findViewById(R.id.list_ed_text);
        addMsg.setText(R.string.med);
        addMsgEd = (EditText) view4.findViewById(R.id.list_edit);

        addTimePicker = (TimePicker) findViewById(R.id.clock_timepicker_v17);
    }

    @Override
    public void addListener() {
        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.clock_add_layout);
                initAddView();

                clockAddTitleView = (TitleView) findViewById(R.id.clock_add_titleview);
                addAddLayoutListener();

                addTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                        showToast(String.valueOf(hourOfDay) + String.valueOf(minute));
                    }
                });

            }
        });

        clockTitleView.setBackBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

    // /*spinner选中监听*/
//        itemSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                setItemPositon(position);
////                getPresenter().itemSelected(position);
//                getPresenter().changeChartData(memberPositon, position);
//                checkMarkView.setItem(getPresenter().getItemSpinnerData().get(position));
//                mLineChart.animateX(200);//从左到右展开
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    private void addAddLayoutListener() {
        clockAddTitleView.setBackBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.clock_layout);
                initView();
                addListener();
            }
        });

        clockAddTitleView.setConfirmBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTimePicker.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);
                addTimePicker.setIs24HourView(true);

                showToast("confirm" + String.valueOf(addTimePicker.getCurrentHour()));
            }
        });
    }

    public Animation at_animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_translate);
        return animation;
    }
}
