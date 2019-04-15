package com.example.msi.familyhealth.Clock;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.msi.familyhealth.Data.DbClockBean;
import com.example.msi.familyhealth.MvpBase.BaseActivity;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.TitleView;

import java.util.Calendar;

public class ClockAddActivity extends BaseActivity<ClockAddContacts.IClockAddPresenter> implements ClockAddContacts.IClockAddView {
    private TitleView clockAddTitleView;
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
        setContentView(R.layout.clock_add_layout);

        initView();

        addListener();

        //  ClockTest();
    }

    @Override
    public ClockAddContacts.IClockAddPresenter onBindPresenter() {
        return new ClockAddPresenter(this);
    }

    @Override
    public void initView() {
        View view1 = (View) findViewById(R.id.clock_sp_text1);
        addMember = (TextView) view1.findViewById(R.id.list_sp_text);
        addMember.setText(R.string.family_member);
        addMemberSp = (Spinner) view1.findViewById(R.id.list_spinner);
        addMemberSp.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.spinnerTv, getPresenter().initMemberSp()));

        View view2 = (View) findViewById(R.id.clock_sp_text2);
        addRepeat = (TextView) view2.findViewById(R.id.list_sp_text);
        addRepeat.setText(R.string.repeat);
        addRepeatSp = (Spinner) view2.findViewById(R.id.list_spinner);
        addRepeatSp.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.spinnerTv, getPresenter().getRepeatData()));

        View view3 = (View) findViewById(R.id.clock_sp_text3);
        addType = (TextView) view3.findViewById(R.id.list_sp_text);
        addType.setText(R.string.type);
        addTypeSp = (Spinner) view3.findViewById(R.id.list_spinner);
        addTypeSp.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.spinnerTv, getPresenter().getTypeData()));

        View view4 = (View) findViewById(R.id.clock_ed_text);
        addMsg = (TextView) view4.findViewById(R.id.list_add_ed_text);
        addMsg.setText(R.string.med);
        addMsgEd = (EditText) view4.findViewById(R.id.list_textedit);

        if (Build.VERSION.SDK_INT >= 17) {
            //真机
            addTimePicker = (TimePicker) findViewById(R.id.clock_timepicker);
            //虚拟机
//            addTimePicker = (TimePicker) findViewById(R.id.clock_timepicker_v17);
        } else {

//            addTimePicker.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);
//            addTimePicker.setIs24HourView(true);
        }
    }

    @Override
    public void addListener() {

        clockAddTitleView = (TitleView) findViewById(R.id.clock_add_titleview);

        addTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                showToast(String.valueOf(hourOfDay) + String.valueOf(minute));
            }
        });

        clockAddTitleView.setBackBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        clockAddTitleView.setConfirmBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("confirm" + String.valueOf(addTimePicker.getCurrentHour()));

                getPresenter().addClockBtClick(ClockAddActivity.this
                        , addTypeSp.getSelectedItemPosition()
                        , addRepeatSp.getSelectedItemPosition()
                        , addTimePicker.getCurrentHour()
                        , addTimePicker.getCurrentMinute()
                        , addMsgEd.getText().toString()
                        , addMemberSp.getSelectedItem().toString()
                );
            }
        });

        addTypeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (addTypeSp.getSelectedItem().equals("事件")) {
                    addMsg.setText("事件内容");
                } else {
                    addMsg.setText("吃药");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setClockOver() {
        Intent intent = new Intent(ClockAddActivity.this, ClockActivity.class);
        startActivity(intent);
        finish();
    }

    public void ClockTest() {
        Log.e("setclock", "!");
        AlarmManagerUtil.setAlarm(this, 0, 14, 19, 0, 0, "测试闹钟", 0);
    }
}
