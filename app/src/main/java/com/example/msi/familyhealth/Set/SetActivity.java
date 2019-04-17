package com.example.msi.familyhealth.Set;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.msi.familyhealth.R;

import android.view.View;

import com.example.msi.familyhealth.MvpBase.*;
import com.example.msi.familyhealth.View.MyListViewAdapter;
import com.example.msi.familyhealth.View.OneListView;
import com.example.msi.familyhealth.View.TitleView;
import com.example.msi.familyhealth.View.ViewHolder;

public class SetActivity extends BaseActivity<SetContacts.ISetPresenter> implements SetContacts.ISetView {

    private OneListView setListView;
    private TitleView titleView;
    private MyListViewAdapter myListViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_layout);

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


    }
}
