package com.chen.pojo;

/**
 */
public class ApplyRecordPO extends BasePO {

    /**
     * 工作流流程id
     */
    private Long processId;

    /**
     * 工作流名称
     */
    private String processName;

    /**
     * 工作流流程版本
     */
    private Integer processVersion;

    /**
     * 业务id
     */
    private Long businessId;

    /**
     * 申请人
     */
    private Long applicant;

    /**
     * 教具id
     */
    private Long toyId;

    private String toyName;

    /**
     * 租借数量
     */
    private Integer borrowNun;

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Integer getProcessVersion() {
        return processVersion;
    }

    public void setProcessVersion(Integer processVersion) {
        this.processVersion = processVersion;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getApplicant() {
        return applicant;
    }

    public void setApplicant(Long applicant) {
        this.applicant = applicant;
    }

    public Long getToyId() {
        return toyId;
    }

    public void setToyId(Long toyId) {
        this.toyId = toyId;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public Integer getBorrowNun() {
        return borrowNun;
    }

    public void setBorrowNun(Integer borrowNun) {
        this.borrowNun = borrowNun;
    }

    @Override
    public String toString() {
        return "ApplyRecordPO{" +
                "processId=" + processId +
                ", processName='" + processName + '\'' +
                ", processVersion=" + processVersion +
                ", businessId=" + businessId +
                ", applicant=" + applicant +
                ", toyId=" + toyId +
                ", toyName='" + toyName + '\'' +
                ", borrowNun=" + borrowNun +
                '}';
    }
}
