package com.example.msi.familyhealth.MyData.DataFragment;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.msi.familyhealth.Data.BaseItemBean;
import com.example.msi.familyhealth.Data.UpDataItem;
import com.example.msi.familyhealth.MvpBase.BaseFragment;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.MainListAdapter;
import com.example.msi.familyhealth.View.ViewHolder;

import java.util.ArrayList;
import java.util.List;

//public class LoginActivity extends BaseActivity<LoginContacts.ILoginPresenter> implements LoginContacts.ILoginView
public class Fragment_commen extends BaseFragment<FragmentComContacts.IFragmentPresenter> implements FragmentComContacts.IFragmentView {
    private ListView listView;

    private int project;//监听项目栏，选择下面的常量，从而改变list布局等
    private static final int BASE = 0;
    private static final int DALIY = 1;
    private static final int BLOOD = 2;


    /**
     * 手动上传界面的Fragment
     * list适配器在此配置
     *
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_commen, container, false);
        listView = (ListView) view.findViewById(R.id.up_data_list);


        View view1 = (View)view.findViewById(R.id.list_sp_text1);
        View view2 = (View)view.findViewById(R.id.list_sp_text2);
        TextView memberTv = (TextView) view1.findViewById(R.id.list_sp_text);
        memberTv.setText(R.string.family_member);
        TextView projectTv = (TextView) view2.findViewById(R.id.list_sp_text);
        projectTv.setText(R.string.project);

        getPresenter().createList();

        listView.setAdapter(new MainListAdapter(this.getContext(), new FragmentComModel().getList()) {
            @Override
            public void convert(ViewHolder viewHolder, String item) {
                switch (getTpye()) {
                    case 0:
                        viewHolder.setText(R.id.list_sp_text, item);
                        break;
                    case 1:
                        viewHolder.setText(R.id.list_ed_text, item);
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public FragmentComContacts.IFragmentPresenter onBindPresenter() {
        return new FragmentComPresenter(this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showToast(String msg) {

    }

}
