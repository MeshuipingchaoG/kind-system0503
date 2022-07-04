package com.chen.pojo;

import java.util.Date;

/**
 * @description 审核记录
 *
 * @date 2022/04/09
 */
public class ApproveRecordPO extends BasePO {

    /**
     * 申请记录id
     */
    private Long applyId;

    /**
     * 当前节点
     */
    private Long curNode;

    /**
     * 下一节点
     */
    private Long nextNode;

    /**
     * 审核人
     */
    private Long approver;

    /**
     * 审核状态
     */
    private Integer approveStatus;

    /**
     * 工作流名称
     */
    private String processName;

    /**
     * 申请人
     */
    private String applicantName;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 教具id
     */
    private Long toyId;

    private String toyName;

    /**
     * 租借数量
     */
    private Integer borrowNun;

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getCurNode() {
        return curNode;
    }

    public void setCurNode(Long curNode) {
        this.curNode = curNode;
    }

    public Long getNextNode() {
        return nextNode;
    }

    public void setNextNode(Long nextNode) {
        this.nextNode = nextNode;
    }

    public Long getApprover() {
        return approver;
    }

    public void setApprover(Long approver) {
        this.approver = approver;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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
        return "ApproveRecordPO{" +
                super.toString() +
                "applyId=" + applyId +
                ", curNode=" + curNode +
                ", nextNode=" + nextNode +
                ", approver=" + approver +
                ", approveStatus=" + approveStatus +
                ", processName='" + processName + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", applyTime=" + applyTime +
                ", toyId=" + toyId +
                ", toyName='" + toyName + '\'' +
                ", borrowNun=" + borrowNun +
                '}';
    }
}
