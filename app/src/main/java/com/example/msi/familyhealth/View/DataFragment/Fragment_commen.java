package com.example.msi.familyhealth.View.DataFragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.msi.familyhealth.Data.UpDataItem;
import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.MainListAdapter;
import com.example.msi.familyhealth.View.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Fragment_commen extends Fragment {
    private ListView listView;
    private List<String> list;
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

        initList();

        listView.setAdapter(new MainListAdapter(this.getContext(), list) {
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

    private void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(UpDataItem.MEMBER_ITEM[i]);
        }
        for (int i = 0;i<4;i++){
            list.add(UpDataItem.BASE_ITEM[i]);
        }
    }

    public List<String> getList() {
        return list;
    }
}
