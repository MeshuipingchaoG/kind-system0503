package com.chen.pojo;

import java.util.Date;

public class MyApplyRecord {
    /**
     * 流程Id
     */
    private Long processId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 用户名
     */
    private String userName;

    @Override
    public String toString() {
        return "MyApplyRecord{" +
                "processId=" + processId +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    ;}
