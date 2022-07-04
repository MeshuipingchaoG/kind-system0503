package com.chen.pojo;

/**
 * @description 流程节点
 *
 * @date 2022/04/09
 */
public class WorkflowNode extends BasePO {

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点类型
     */
    private Integer nodeType;

    /**
     * 流程ID
     */
    private Long processId;

    /**
     * 下个节点id
     */
    private Long nextNodeId;

    public WorkflowNode() {

    }

    public WorkflowNode(String name, Integer nodeType, Long processId) {
        this.name = name;
        this.nodeType = nodeType;
        this.processId = processId;
    }

    public WorkflowNode(String name, Integer nodeType, Long processId, Long nextNodeId) {
        this.name = name;
        this.nodeType = nodeType;
        this.processId = processId;
        this.nextNodeId = nextNodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Long getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(Long nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    @Override
    public String toString() {
        return "WorkflowNode{" +
                super.toString() +
                "name='" + name + '\'' +
                ", nodeType=" + nodeType +
                ", processId=" + processId +
                ", nextNodeId=" + nextNodeId +
                '}';
    }
}
