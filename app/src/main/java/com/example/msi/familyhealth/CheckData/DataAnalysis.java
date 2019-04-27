package com.example.msi.familyhealth.CheckData;

import java.util.List;

/**
 * 血糖范围（3.9-7.8）
 * 血压-收缩压90-140-舒张压60-90
 */
public class DataAnalysis {
    public static String dailyDataAnalysis(List<Float> dataList, int itemPosition) {
        int heigh = 0;
        int low = 0;
        Float total;
        String result;
        result = "";

        StringBuilder stringBuilder = new StringBuilder().append(result);

        if (dataList.size() == 0) {
            return stringBuilder.append("暂无数据").toString();
        }

        if (dataList.size() < 4) {
            return stringBuilder.append("数据量少，暂无分析，点击数据可查看是否有异常").toString();
        }

        switch (itemPosition) {
            case 0:
                total = Float.valueOf(0);
                float data = 0;
                heigh = 0;
                low = 0;
                int len = dataList.size();

                for (int i = 0; i < len; i++) {
                    data = dataList.get(i);//下面会多次用到，用变量先赋值，避免每次都从list中get一次。
                    if (data > 7.8) {
                        heigh++;
                    } else if (data < 3.9) {
                        low++;
                    }
                    total += data;
                }

                if (heigh > (len * 0.5)) {
                    result = "血糖高，请注意坚持服药监控。\n";
                } else if (heigh > (len * 0.3)) {
                    result = "血糖偏高，请注意日常控制。\n";
                } else if (heigh > (len * 0.1)) {
                    result = "偶有血糖偏高的情况，请开始注意饮食习惯。\n";
                } else if (heigh > 0) {
                    result = "饭后测量的数据可能会导致血糖短暂偏高，不用太担心，注意饮食习惯。\n";
                } else if (heigh == 0) {
                    result = "完全没有血糖过高的情况，很健康\n";
                }
                stringBuilder.append(result);

                if (low > (len * 0.5)) {
                    result = "长期低血糖，请就医咨询。\n";
                } else if (low > (len * 0.3)) {
                    result = "经常有血糖偏低的情况，请注意日常控制。\n";
                } else if (low > (len * 0.1)) {
                    result = "偶有低血糖，请开始注意饮食习惯。\n";
                } else if (low > 0) {
                    result = "偶有血糖偏低的情况，不用太担心，注意规律饮食。\n";
                } else if (low == 0) {
                    result = "完全没有低血糖的情况，很健康。\n";
                }
                stringBuilder.append(result);

                return standardDeviationResult(dataList, total, stringBuilder, len).toString();
        }
        return stringBuilder.append("暂无分析结果").toString();
    }

    public static StringBuilder standardDeviationResult(List<Float> dataList, Float total, StringBuilder stringBuilder, int len) {
        String result = null;
        double standardDeviation;
        double n = 0;
        for (int i = 0; i < len; i++) {
            n += Math.pow((dataList.get(i) - (total / len)), 2);
        }
        standardDeviation = Math.sqrt(n / len);

        stringBuilder.append("波动情况：（数据波动过大，有异常）/（波动小,健康情况很稳定）");
        return stringBuilder;
    }
}