package com.example.msi.familyhealth.CheckData;

import com.example.msi.familyhealth.Data.DbDailyDataBean;

import java.util.List;

/**
 * 血糖范围（3.9-7.8）
 * 血压-收缩压90-140-舒张压60-90
 */
public class DataAnalysis {
    public static String dailyDataAnalysis(List<Float> dataList, int itemPosition) {
        int heigh = 0;
        int low = 0;
        String result;
        result = "";
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder().append(result);

        switch (itemPosition) {
            case 0:
                for (int len = dataList.size(); i < len; i++) {
                    if (dataList.get(i) > 7.8) {
                        heigh++;
                    } else if (dataList.get(i) < 3.9) {
                        low++;
                    }
                }

                if (heigh > (i * 0.5)) {
                    result = "血糖高，请注意坚持服药监控。";
                } else if (heigh > (i * 0.3)) {
                    result = "血糖偏高，请注意日常控制。";
                } else if (heigh > (i * 0.1)) {
                    result = "偶有血糖偏高的情况，请开始注意饮食习惯。";
                } else if (heigh > 0) {
                    result = "偶有血糖偏高的情况，饭后测量的数据可能会导致血糖短暂偏高，不用太担心，注意饮食习惯。";
                } else if (heigh == 0) {
                    result = "完全没有血糖过高的情况，很健康";
                }
                stringBuilder.append(result);

                if (low > (i * 0.5)) {
                    result = "长期低血糖，请就医咨询。";
                } else if (low > (i * 0.3)) {
                    result = "经常有血糖偏低的情况，请注意日常控制。";
                } else if (low > (i * 0.1)) {
                    result = "偶有低血糖，请开始注意饮食习惯。";
                } else if (low > 0) {
                    result = "偶有血糖偏低的情况，不用太担心，注意规律饮食。";
                } else if (low == 0) {
                    result = "完全没有低血糖的情况，很健康。";
                }
                stringBuilder.append(result);
        }

        return stringBuilder.toString();
    }
}
