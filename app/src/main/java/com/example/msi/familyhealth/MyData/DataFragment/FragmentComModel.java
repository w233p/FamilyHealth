package com.example.msi.familyhealth.MyData.DataFragment;

import android.util.Log;

import com.example.msi.familyhealth.Data.BaseItemBean;
import com.example.msi.familyhealth.Data.UpDataItem;

import java.util.ArrayList;
import java.util.List;

public class FragmentComModel implements FragmentComContacts.IFragmentModel {
    private static List<String> list;


    @Override
    public void initList() {
        list = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            list.add(UpDataItem.MEMBER_ITEM[i]);
//        }
        for (int i = 0; i < 3; i++) {
            list.add(UpDataItem.BASE_ITEM[i]);
        }
    }

    public static List<String> getList() {
        return list;
    }

}
