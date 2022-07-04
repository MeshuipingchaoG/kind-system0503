package com.chen.pojo;

import com.chen.enums.BusinessCodeEnum;

/**
 * @description 审核记录
 *
 * @date 2022/04/09
 */
public class BusinessWorkflowRelation extends BasePO {

    /**
     * 业务code
     * @see BusinessCodeEnum
     */
    private String businessCode;

    /**
     * 工作流流程id
     */
    private Long processId;

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "BusinessWrokflowRelation{" +
                super.toString() +
                "businessCode='" + businessCode + '\'' +
                ", processId=" + processId +
                '}';
    }
}
