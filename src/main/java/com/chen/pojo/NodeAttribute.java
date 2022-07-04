package com.chen.pojo;

/**
 * @description 流程节点
 *
 * @date 2022/04/09
 */
public class NodeAttribute extends BasePO {

    /**
     * 节点id
     */
    private Long nodeId;

    /**
     * 审批人
     */
    private String approver;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    @Override
    public String toString() {
        return "NodeAttribute{" +
                super.toString() +
                ", nodeId=" + nodeId +
                ", approver='" + approver + '\'' +
                '}';
    }
}
