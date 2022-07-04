package com.chen.pojo;

import java.util.Date;

/**
 * @description 工作流流程
 *
 * @author shihao36
 * @date 2022/04/09
 */
public class WorkflowProcess extends BasePO {

    /**
     * 流程名称
     */
    private String name;

    /**
     * 流程简介
     */
    private String summary;

    /**
     * 流程版本
     */
    private Integer version;

    public WorkflowProcess() {

    }

    public WorkflowProcess(String name, String summary, Integer version) {
        this.name = name;
        this.summary = summary;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "WorkflowProcess{" +
                super.toString() +
                "name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", version=" + version +
                '}';
    }
}
