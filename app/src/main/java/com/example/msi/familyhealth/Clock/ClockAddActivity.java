package com.example.msi.familyhealth.Clock;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

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

        ClockTest();
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

        View view2 = (View) findViewById(R.id.clock_sp_text2);
        addRepeat = (TextView) view2.findViewById(R.id.list_sp_text);
        addRepeat.setText(R.string.repeat);
        addRepeatSp = (Spinner) view2.findViewById(R.id.list_spinner);

        View view3 = (View) findViewById(R.id.clock_sp_text3);
        addType = (TextView) view3.findViewById(R.id.list_sp_text);
        addType.setText(R.string.type);
        addTypeSp = (Spinner) view3.findViewById(R.id.list_spinner);

        View view4 = (View) findViewById(R.id.clock_ed_text);
        addMsg = (TextView) view4.findViewById(R.id.list_add_ed_text);
        addMsg.setText(R.string.med);
        addMsgEd = (EditText) view4.findViewById(R.id.list_textedit);

        if (Build.VERSION.SDK_INT >= 17) {
            addTimePicker = (TimePicker) findViewById(R.id.clock_timepicker);
        } else {
            addTimePicker = (TimePicker) findViewById(R.id.clock_timepicker_v17);
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
            }
        });
    }

    public void SetClock() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();


    }

    public void ClockTest() {
        Log.e("setclock","!");
        AlarmManagerUtil.setAlarm(this, 0, 14, 19, 0, 0, "测试闹钟", 0);
    }
}
