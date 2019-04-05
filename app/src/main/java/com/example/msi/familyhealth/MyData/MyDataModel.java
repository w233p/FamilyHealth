package com.example.msi.familyhealth.MyData;

import android.util.Log;
import android.widget.Toast;

import com.example.msi.familyhealth.Data.DbDailyDataBean;
import com.example.msi.familyhealth.Data.DbItemBean;
import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.Data.DbMemberMessageBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.MvpBase.BaseFragment;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComContacts;

import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MyDataModel implements MyDataContacts.IMyDataModel {
    private String[] temporaryData;

    public void initTemporaryData() {
        temporaryData = new String[10];
        for (int i = 0; i < 10; i++) {
            temporaryData[i] = "0";
        }
    }

    public void getEditText(int position, String str) {
        Log.e("判断", "项目");

        temporaryData[position] = str;
        for (int i = 0; i < 10; i++) {
            Log.e("data", position + "::" + temporaryData[i]);
        }
    }

    public int getInt(int dataPosition) {
        int in = Integer.valueOf(temporaryData[dataPosition]);
        return in;
    }

    public float getFloat(int dataPosition) {
        float fl = Float.valueOf(temporaryData[dataPosition]);
        return fl;
    }


    @Override
    public void saveBaseToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen) {
        //先找到成员
        List<DbMemberBean> dbMemberBeanList = DataSupport
                .where("memberName = ?",
                        String.valueOf(fragment_commen.getPresenter().getFragmentComModel().getMemberSpText()))
                .find(DbMemberBean.class);

        //删除该成员历史的基本信息
        List<DbMemberMessageBean> dbMemberMessageBeanList = DataSupport.where("dbmemberbean_id = ?", String.valueOf(dbMemberBeanList.get(0).getId())).find(DbMemberMessageBean.class);
        for (int i = 0; i < dbMemberMessageBeanList.size(); i++) {
            Log.e("getId", String.valueOf(dbMemberMessageBeanList.get(i).getId()));
            dbMemberMessageBeanList.get(i).delete();
        }

        //添加新的基本信息
        DbMemberMessageBean dbMemberMessageBean = new DbMemberMessageBean()
                .setAge(getInt(0))
                .setHeight(getInt(1))
                .setWeight(getFloat(2))
                .setDbMemberBean(dbMemberBeanList.get(0));
        dbMemberMessageBean.save();
    }

    @Override
    public void saveDailyToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen) {
        //先找到成员
        List<DbMemberBean> dbMemberBeanList = DataSupport
                .where("memberName = ?",
                        String.valueOf(fragment_commen.getPresenter().getFragmentComModel().getMemberSpText()))
                .find(DbMemberBean.class);

        //添加新的基本信息
        Date date = new Date();
        long dateTime = date.getTime();
        long zero = dateTime / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天0点的毫秒数
        long twelve = zero +24*60*60*1000-1;//今天23点59分59秒

        //item :血糖id=1 高压id=2 低压id=3
        for (int i = 0; i < 3; i++) {
            DbDailyDataBean dbDailyDataBean = new DbDailyDataBean();
            dbDailyDataBean.setTime(twelve);
            dbDailyDataBean.setData(getFloat(i))
                    .setDbItemBean(DataSupport.find(DbItemBean.class, i + 1))
                    .setDbMemberBean(dbMemberBeanList.get(0));
            dbDailyDataBean.save();
        }

        DataSupport.delete(DbDailyDataBean.class, 7);
        DataSupport.delete(DbDailyDataBean.class, 8);
        DataSupport.delete(DbDailyDataBean.class, 9);
        DataSupport.delete(DbDailyDataBean.class, 10);
        DataSupport.delete(DbDailyDataBean.class, 11);
        DataSupport.delete(DbDailyDataBean.class, 12);
    }

    @Override
    public void saveBloodToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen) {

    }

    @Override
    public void saveUrineToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen) {

    }

    @Override
    public void saveInsulinToDb(BaseFragment<FragmentComContacts.IFragmentPresenter> fragment_commen) {

    }

    /**
     * 临时初始化项目的数据库
     */
    public void initItemDataBase() {
        DbProjectBean dbProjectBean = new DbProjectBean().setProject("日常");
        dbProjectBean.save();
        DbProjectBean dbProjectBean1 = new DbProjectBean().setProject("血液");
        dbProjectBean1.save();
        DbProjectBean dbProjectBean2 = new DbProjectBean().setProject("尿检");
        dbProjectBean2.save();
        DbProjectBean dbProjectBean3 = new DbProjectBean().setProject("糖尿病");
        dbProjectBean3.save();
        DbProjectBean dbProjectBean4 = new DbProjectBean().setProject("基本信息");
        dbProjectBean4.save();

        DbItemBean dbItemBean = new DbItemBean().setItem("血糖");
        dbItemBean.setDbProjectBean(dbProjectBean).save();
        DbItemBean dbItemBean1 = new DbItemBean().setItem("高压");
        dbItemBean1.setDbProjectBean(dbProjectBean).save();
        DbItemBean dbItemBean2 = new DbItemBean().setItem("低压");
        dbItemBean2.setDbProjectBean(dbProjectBean).save();
//        "甘油三酯", "胆固醇", "红细胞", "红细胞体积分布宽度", "白细胞", "血小板"
//            , "糖化血红蛋白", "心肌酶", "血尿酸"
        DbItemBean dbItemBean3 = new DbItemBean().setItem("甘油三酯");
        dbItemBean3.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean4 = new DbItemBean().setItem("胆固醇");
        dbItemBean4.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean5 = new DbItemBean().setItem("红细胞");
        dbItemBean5.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean6 = new DbItemBean().setItem("红细胞体积分布宽度");
        dbItemBean6.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean7 = new DbItemBean().setItem("白细胞");
        dbItemBean7.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean8 = new DbItemBean().setItem("血小板");
        dbItemBean8.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean9 = new DbItemBean().setItem("糖化血红蛋白");
        dbItemBean9.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean10 = new DbItemBean().setItem("心肌酶");
        dbItemBean10.setDbProjectBean(dbProjectBean1).save();
        DbItemBean dbItemBean11 = new DbItemBean().setItem("血尿酸");
        dbItemBean11.setDbProjectBean(dbProjectBean1).save();
//        {"PH", "蛋白质", "比重", "潜血", "微量白蛋白", "肌酐"};
        DbItemBean dbItemBean12 = new DbItemBean().setItem("PH");
        dbItemBean12.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean13 = new DbItemBean().setItem("蛋白质");
        dbItemBean13.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean14 = new DbItemBean().setItem("比重");
        dbItemBean14.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean15 = new DbItemBean().setItem("潜血");
        dbItemBean15.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean16 = new DbItemBean().setItem("微量白蛋白");
        dbItemBean16.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean17 = new DbItemBean().setItem("肌酐");
        dbItemBean17.setDbProjectBean(dbProjectBean2).save();
//        "胰岛素","ICA抗胰岛细胞抗体","GAD抗谷氨酸脱氢酶抗体","IAA抗胰岛素抗体"
        DbItemBean dbItemBean18 = new DbItemBean().setItem("胰岛素");
        dbItemBean18.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean19 = new DbItemBean().setItem("ICA抗胰岛细胞抗体");
        dbItemBean19.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean20 = new DbItemBean().setItem("GAD抗谷氨酸脱氢酶抗体");
        dbItemBean20.setDbProjectBean(dbProjectBean2).save();
        DbItemBean dbItemBean21 = new DbItemBean().setItem("IAA抗胰岛素抗体");
        dbItemBean21.setDbProjectBean(dbProjectBean2).save();
    }
}
