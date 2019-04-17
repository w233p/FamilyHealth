package com.example.msi.familyhealth.Set;

import java.util.ArrayList;
import java.util.List;
//<!--<TextView-->
//		<!--android:id="@id/acountTv linkMember Jianhuren CallNumber ExitAcount ExitApp"/>-->
//    <!---->
public class SetModel implements SetContacts.ISetModel {
    @Override
    public List<String> initSetListDataItem() {
        List<String> dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("账号");
        dataList.add("关联家人");
        dataList.add("1");
        dataList.add("监护人选项");
        dataList.add("紧急呼叫号码");
        dataList.add("1");
        dataList.add("退出账号");
        dataList.add("退出软件");
        return dataList;
    }
}
