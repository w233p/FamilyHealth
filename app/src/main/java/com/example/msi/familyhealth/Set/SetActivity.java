package com.example.msi.familyhealth.Set;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.msi.familyhealth.R;

import android.view.View;
import android.widget.AdapterView;

import com.example.msi.familyhealth.MvpBase.*;
import com.example.msi.familyhealth.View.MyListViewAdapter;
import com.example.msi.familyhealth.View.OneListView;
import com.example.msi.familyhealth.View.TitleView;
import com.example.msi.familyhealth.View.TwoEditDialog;
import com.example.msi.familyhealth.View.ViewHolder;
import android.content.*;
import com.example.msi.familyhealth.Login.*;
import java.util.*;

public class SetActivity extends BaseActivity<SetContacts.ISetPresenter> implements SetContacts.ISetView {

    private OneListView setListView;
    private TitleView titleView;
    private MyListViewAdapter myListViewAdapter;
	private List<Activity> activityList= new LinkedList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_layout);
		
		ExitApplication.getInstance().addActivity(this);

        initView();

        addListener();
    }

    @Override
    public SetContacts.ISetPresenter onBindPresenter() {
        return new SetPresents(this);
    }

    @Override
    public void initView() {
        setListView = (OneListView) findViewById(R.id.set_listview);
        titleView = (TitleView) findViewById(R.id.set_titleView);

        myListViewAdapter = new MyListViewAdapter(this, getPresenter().getSetListDataItem()) {
            @Override
            public void convert(ViewHolder viewHolder, String item) {
                if (item == "1") {
                    viewHolder.setBackGround(R.id.list_text_layout);
                } else {
                    viewHolder.setText(R.id.list_text, item);
                }
            }
        };

        setListView.setAdapter(myListViewAdapter);
    }

    @Override
    public void addListener() {
        titleView.setBackBtOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 2:
                        TwoEditDialog twoEditDialog = new TwoEditDialog.Builder(SetActivity.this).create();
                        twoEditDialog.show();
                        break;
                    case 5:
                        break;
                    case 7:
						Intent intent = new Intent(SetActivity.this,LoginActivity.class);
						startActivity(intent);
                        break;
                    case 8:
                        break;
                    default:
                        break;
                }
            }
        });
    }
	
	public void exit(){
		for(Activity act:activityList){
			act.finish();
		}
		System.exit(0);
	}
}
