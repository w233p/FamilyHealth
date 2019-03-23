package com.example.msi.familyhealth.Data;

import java.util.List;

/**
 * 成员、项目信息Bean类
 */
public class MemberBean {
    public static final String MEMBER_ITEM[] = {"成员", "项目"};
    public static final int LIST_TYPE[] = {0, 0};
    private String member;
    private String project;

    public String getMember() {
        return member;
    }

    public MemberBean setMember(String member) {
        this.member = member;
        return this;
    }

    public String getProject() {
        return project;
    }

    public MemberBean setProject(String project) {
        this.project = project;
        return this;
    }

}
