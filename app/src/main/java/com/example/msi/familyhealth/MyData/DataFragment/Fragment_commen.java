package com.example.msi.familyhealth.MyData.DataFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.MvpBase.BaseFragment;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.MainListAdapter;
import com.example.msi.familyhealth.View.ViewHolder;

import org.litepal.crud.DataSupport;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

//public class LoginActivity extends BaseActivity<LoginContacts.ILoginPresenter> implements LoginContacts.ILoginView
public class Fragment_commen extends BaseFragment<FragmentComContacts.IFragmentPresenter> implements FragmentComContacts.IFragmentView {
    private ListView listView;

    private TextView memberTv;
    private TextView projectTv;
    private Spinner memberSp;
    private Spinner projectSp;
    private MainListAdapter mainListAdapter;


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

        initView(view);

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

    /**
     * @param view
     */
    public void initView(View view) {
        listView = (ListView) view.findViewById(R.id.up_data_list);
        View view1 = (View) view.findViewById(R.id.list_sp_text1);
        View view2 = (View) view.findViewById(R.id.list_sp_text2);
        memberTv = (TextView) view1.findViewById(R.id.list_sp_text);
        memberTv.setText(R.string.family_member);
        projectTv = (TextView) view2.findViewById(R.id.list_sp_text);
        projectTv.setText(R.string.project);
        memberSp = (Spinner) view1.findViewById(R.id.list_spinner);
        projectSp = (Spinner) view2.findViewById(R.id.list_spinner);

        getPresenter().createList();


        mainListAdapter = new MainListAdapter(this.getContext(), getPresenter().getFragmentComModel().getList()) {
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
        };
        listView.setAdapter(mainListAdapter);

        projectSp.setAdapter(new ArrayAdapter<String>(this.getContext(), R.layout.spinner_item, R.id.spinnerTv, getPresenter().getFragmentComModel().getProjectList()));

        /*spinner选中监听*/
        projectSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getPresenter().projectSelect((String) projectSp.getSelectedItem());
//                listView.setAdapter(mainListAdapter);
                mainListAdapter.notifyDataSetChanged();
                listView.startAnimation(at_animation());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public Animation at_animation() {
        Animation animation = AnimationUtils.loadAnimation(this.getContext(), R.anim.alpha_translate);
        return animation;
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showToast(String msg) {

    }

}
