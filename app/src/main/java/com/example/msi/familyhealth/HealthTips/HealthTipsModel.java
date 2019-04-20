package com.example.msi.familyhealth.HealthTips;

import java.util.ArrayList;
import java.util.List;

public class HealthTipsModel implements HealthTipsContacts.IHealthTipModel {
    List<String> tipList = new ArrayList<>();

    @Override
    public List<String> initTipData() {
        for (int i = 0; i < 6; i++) {
            tipList.add(i + "测试数据");
        }
        return tipList;
    }
}
