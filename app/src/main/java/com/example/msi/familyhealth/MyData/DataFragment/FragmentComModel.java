package com.example.msi.familyhealth.MyData.DataFragment;

import android.util.Log;

import com.example.msi.familyhealth.Data.DbMemberBean;
import com.example.msi.familyhealth.Data.DbProjectBean;
import com.example.msi.familyhealth.Data.UpDataItem;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class FragmentComModel implements FragmentComContacts.IFragmentModel {
    private List<String> list;
    private String projectSpText = "基本信息";
    private String memberSpText = "";
    private List<String> projectList;
    private List<String> memberList;

    /**
     * 获取project的所有项
     */
    public void initSpinnerList() {
        List<DbProjectBean> allDbProjectBean = DataSupport.findAll(DbProjectBean.class);
        projectList = new ArrayList<>();
        for (int i = 0; i < allDbProjectBean.size(); i++) {
            projectList.add(allDbProjectBean.get(i).getProject());
        }
    }

    public void initMemberList(){
        List<DbMemberBean> allDbMemberBean = DataSupport.findAll(DbMemberBean.class);
        memberList = new ArrayList<>();
        for (int i = 0;i<allDbMemberBean.size();i++){
            memberList.add(allDbMemberBean.get(i).getMemberName());
        }
    }

    @Override
    public void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(UpDataItem.DAILY[i]);
            Log.e("ric", list.get(i));
        }
    }

    /**
     * 根据spinner的项目更新列表
     * 注意：列表传给adapter的是对象，更新数据只能更那一个对象，不能new一个list
     */
    public void refreshList() {
        list.clear();
        Log.e("projectSpText", projectSpText);
        if (projectSpText.equals(null) || projectSpText.equals("基本信息")) {
            for (int i = 0; i < 3; i++) {
                list.add(UpDataItem.BASE_ITEM[i]);
                Log.e("base", list.get(i));
            }
        } else if (projectSpText.equals("日常")) {
            for (int i = 0; i < 3; i++) {
                list.add(UpDataItem.DAILY[i]);
                Log.e("ric", list.get(i));
            }
        } else if (projectSpText.equals("血液")) {
            for (int i = 0; i < 3; i++) {
                list.add(UpDataItem.BLOOD[i]);
                Log.e("blood", list.get(i));
            }
        } else if (projectSpText.equals("尿检")) {
            for (int i = 0; i < 3; i++) {
                list.add(UpDataItem.URINE[i]);
                Log.e("blood", list.get(i));
            }
        }else if (projectSpText.equals("糖尿病")) {
            for (int i = 0; i < 3; i++) {
                list.add(UpDataItem.INSULIN[i]);
                Log.e("blood", list.get(i));
            }
        }
    }

    public List<String> getList() {
        return list;
    }

    public String getProjectSpText() {
        return projectSpText;
    }

    public void setProjectSpText(String projectSpText) {
        this.projectSpText = projectSpText;
    }

    public String getMemberSpText() {
        return memberSpText;
    }

    public void setMemberSpText(String memberSpText) {
        this.memberSpText = memberSpText;
    }

    public List<String> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<String> projectList) {
        this.projectList = projectList;
    }

    public List<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }
}
