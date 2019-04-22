package com.example.msi.familyhealth.Data;

import java.util.List;

/**
 * 手动上传数据的项目
 */
public class UpDataItem {
    public static final String MEMBER_ITEM[] = {"成员", "项目"};//text
    public static final String BASE_ITEM[] = {"年龄/岁", "身高/cm", "体重/kg"};//spinner，ed*3
    /**
     * 日常项目
     * 注，原为血糖血脂血压，现改为血糖，高低压
     * 血糖范围（3.9-7.8）
     * 血压-收缩压90-140-舒张压60-90
     */
    public static final String DAILY[] = {"血糖(mmol/L)", "高压(mmHg）", "低压(mmHg)"};//ed
    /**
     * 血检项目
     */
    public static final String BLOOD[] = {"甘油三酯", "胆固醇", "红细胞", "红细胞体积分布宽度", "白细胞", "血小板"
            , "糖化血红蛋白", "心肌酶", "血尿酸"};//ed

    /**
     * 家用尿液分析仪
     */
    public static final String URINE[] = {"PH", "蛋白质", "比重", "潜血", "微量白蛋白", "肌酐"};
    /**
     * 糖尿病相关
     */
    public static final String INSULIN[] = {"胰岛素", "ICA抗胰岛细胞抗体", "GAD抗谷氨酸脱氢酶抗体", "IAA抗胰岛素抗体"};

}

