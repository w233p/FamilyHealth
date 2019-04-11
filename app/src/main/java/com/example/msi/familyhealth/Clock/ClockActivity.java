package com.example.msi.familyhealth.Clock;

import android.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.example.msi.familyhealth.MvpBase.*;
import com.example.msi.familyhealth.View.*;

//public class CheckDataActivity extends BaseActivity<CheckDataContacts.ICheckDataPresenter> implements CheckDataContacts.ICheckDataView {
public class ClockActivity extends BaseActivity<ClockContacts.IClockPresenter> implements ClockContacts.IClockView
{
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
    protected void onCreate(@Nullable Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_layout);

        initView();

        addListener();

    }

    @Override
    public ClockContacts.IClockPresenter onBindPresenter()
	{
        return null;
    }

    @Override
    public void initView()
	{
        /*设置Button的样式*/
        addBt = (Button) findViewById(R.id.clock_add);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10);
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(getResources().getColor(R.color.loginYellow));
        addBt.setBackground(gradientDrawable);

        clockTitleView = (TitleView) findViewById(R.id.clock_titleView);

        clockListView = (ListView) findViewById(R.id.clock_listview);

//        clockListAdapter = new MainListAdapter(this, getPresenter().getFragmentComModel().getList()) {
//            @Override
//            public void convert(ViewHolder viewHolder, String item) {
//                switch (getTpye()) {
//                    case 0:
//                       //getmeddata
//                        break;
//                    case 1:
//                        //geteventdata
//                        break;
//                }
//            }
//        };
//        clockListView.setAdapter(clockListAdapter);
    }

    private void initAddView()
	{
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

		addTimePicker = (TimePicker)findViewById(R.id.clock_timepicker);
    }

    @Override
    public void addListener()
	{
        addBt.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					setContentView(R.layout.clock_add_layout);
					initAddView();

					clockAddTitleView = (TitleView) findViewById(R.id.clock_add_titleview);
					addAddLayoutListener();

					addTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
							@Override
							public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
							{
								showToast(String.valueOf(hourOfDay) + String.valueOf(minute));
							}
						});
						
				}
			});

        clockTitleView.setBackBtOnclickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					finish();
				}
			});
    }

    private void addAddLayoutListener()
	{
        clockAddTitleView.setBackBtOnclickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					setContentView(R.layout.clock_layout);
					initView();
					addListener();
				}
			});

        clockAddTitleView.setConfirmBtOnclickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					addTimePicker.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);
					addTimePicker.setIs24HourView(true);

					showToast("confirm");
				}
			});
    }
}
