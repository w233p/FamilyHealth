package com.example.msi.familyhealth.View.DataFragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.msi.familyhealth.R;
import com.example.msi.familyhealth.View.MainListAdapter;
import com.example.msi.familyhealth.View.MyListViewAdapter;
import com.example.msi.familyhealth.View.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class Fragment_commen extends Fragment {
    private ListView listView;
    private List<String> list;

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
                        viewHolder.setText(R.id.list_text, item);
                        break;
                    case 1:
                        viewHolder.setText(R.id.list_text2_1, item);
                        viewHolder.setText(R.id.list_text2_2, item);
                }

            }
        });
        return view;
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("测试" + i);
        }
    }

    public List<String> getList(){
        return list;
    }
}
