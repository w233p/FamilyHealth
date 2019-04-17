package com.example.msi.familyhealth.Set;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.msi.familyhealth.R;
import android.widget.*;
import com.example.msi.familyhealth.MvpBase.*;

public class SetActivity extends BaseActivity<SetContacts.ISetPresenter> interface SetContacts.ISetView {
	private ListView setListView;
	
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_layout);
		
		setListView =(ListView)findViewById(R.id.set_listview);
		

    }
	
	   @Override
    public SetContacts.ISetPresenter onBindPresenter() {
        return new SetPresents(this);
    }

	
}
