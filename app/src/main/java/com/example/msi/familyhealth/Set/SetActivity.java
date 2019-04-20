package com.example.msi.familyhealth.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.msi.familyhealth.Data.DbAccountBean;
import com.example.msi.familyhealth.R;

import android.view.View;
import android.widget.AdapterView;

import com.example.msi.familyhealth.MvpBase.*;
import com.example.msi.familyhealth.View.ExitApplication;
import com.example.msi.familyhealth.View.MyListViewAdapter;
import com.example.msi.familyhealth.View.OneListView;
import com.example.msi.familyhealth.View.TitleView;
import com.example.msi.familyhealth.View.TwoEditDialog;
import com.example.msi.familyhealth.View.ViewHolder;

import android.content.*;

import com.example.msi.familyhealth.Login.*;

import org.litepal.crud.DataSupport;

import java.util.*;

public class SetActivity extends BaseActivity<SetContacts.ISetPresenter> implements SetContacts.ISetView {

    private OneListView setListView;
    private TitleView titleView;
    private MyListViewAdapter myListViewAdapter;
    private List<Activity> activityList = new LinkedList();
    public String phoneNumber;

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
                        TwoEditDialog.Builder twoEditBuilder = new TwoEditDialog.Builder(SetActivity.this);

                        twoEditBuilder.setPositiveButton(getString(R.string.confirm), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getPresenter().addMemberClick(twoEditBuilder.getMemberNameText(), twoEditBuilder.getPhoneText());
                            }
                        })
                                .setNegativeButton(getString(R.string.cancel), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        showToast("addmember,cancle");
                                    }
                                });

                        TwoEditDialog twoEditDialog = twoEditBuilder.create();

                        twoEditDialog.show();
                        break;
                    case 5:
                        AlertDialog.Builder builder = new AlertDialog.Builder(SetActivity.this);
                        builder.setTitle("设置谁为紧急联系人");
                        builder.setSingleChoiceItems(getPresenter().getMemberList(), -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                phoneNumber = getPresenter().getPhoneNumber(which);
                                showToast(phoneNumber);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("callnumber", phoneNumber);
                                DataSupport.update(DbAccountBean.class, contentValues, 1);
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        break;
                    case 7:
                        Intent intent = new Intent(SetActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 8:
                        ExitApplication.getInstance().finishAllActivity();//退出所有activity
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
