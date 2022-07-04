package com.chen.pojo;

/**
 * @description 流程记录
 *
 * @date 2022/04/09
 */
public class ApplyRecord extends BasePO {

    /**
     * 工作流流程id
     */
    private Long processId;

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

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
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

    @Override
    public String toString() {
        return "ApplyRecord{" +
                super.toString() +
                "processId=" + processId +
                ", processVersion=" + processVersion +
                ", businessId=" + businessId +
                ", applicant=" + applicant +
                '}';
    }
}
