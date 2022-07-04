package com.chen.pojo;

/**
 * @description 审核记录
 *
 * @date 2022/04/09
 */
public class ApproveRecord extends BasePO {

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

    @Override
    public String toString() {
        return "ApproveRecord{" +
                super.toString() +
                "applyId=" + applyId +
                ", curNode=" + curNode +
                ", nextNode=" + nextNode +
                ", approver=" + approver +
                ", approveStatus=" + approveStatus +
                '}';
    }
}
