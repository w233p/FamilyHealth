package com.example.msi.familyhealth.Clock;

import com.example.msi.familyhealth.Data.DbMemberBean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import com.example.msi.familyhealth.Data.*;

import android.content.*;

public class ClockAddModel implements ClockAddContacts.IClockAddModel {
    List<DbMemberBean> dbMemberBeanList;
    List<String> member;

    /**
     * @return 返回所有的成员
     */
    @Override
    public List<String> memberSpinnerData() {
        dbMemberBeanList = DataSupport.findAll(DbMemberBean.class);
        member = new ArrayList<>();

        for (int i = 0; i < dbMemberBeanList.size(); i++) {
            member.add(dbMemberBeanList.get(i).getMemberName());
        }
        return member;
    }

    public List<String> repeatData() {
        List<String> list = new ArrayList<>();
        list.add("单次");
        list.add("重复");
        return list;
    }

    @Override
    public List<String> TypeData() {
        List<String> list = new ArrayList<>();
        list.add("吃药");
        list.add("事件");
        return list;
    }

    public void setClockDb(Context context, int type, int repeat, int hour, int minute, String medOrEventName, String memberName) {
        List<DbMemberBean> dbMemberBeanList = DataSupport
                .where("membername = ?", memberName)
                .find(DbMemberBean.class);

        DbClockBean dbClockBean = new DbClockBean()
                .setType(type)
                .setRepeat(repeat)
                .setHour(hour)
                .setMinute(minute)
                .setMedOrEventName(medOrEventName)
                .setDbMemberBean(dbMemberBeanList.get(0));

        dbClockBean.save();

        /**
         * @param flag 周期性时间间隔的标志,flag = 0 表示一次性的闹钟, flag = 1 表示每天提醒的闹钟(1天的时间间隔),flag = 2 表示按周每周提醒的闹钟（一周的周期性时间间隔）
         @param hour 时
         @param minute 分
         @param id 闹钟的id
         @param week week=0表示一次性闹钟或者按天的周期性闹钟，非0 的情况下是几就代表以周为周期性的周几的闹钟
         @param tips 闹钟提示信息
         @param soundOrVibrator 2表示声音和震动都执行，1表示只有铃声提醒，0表示只有震动提醒
          * */
        AlarmManagerUtil.setAlarm(context, repeat, hour, minute, dbClockBean.getId(), 0, medOrEventName, 0);
    }
}
