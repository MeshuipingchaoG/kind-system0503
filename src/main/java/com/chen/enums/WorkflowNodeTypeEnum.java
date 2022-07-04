package com.chen.enums;

/**
 * @description 工作流节点类型枚举
 *
 * @date 2022/04/10
 */
public enum WorkflowNodeTypeEnum {

    END_NODE(-1, "结束节点"),

    START_NODE(0, "开始节点"),

    PEOPLE_NODE(1, "人工节点"),

    AUTO_NODE(2, "自动节点"),

    ;

    private Integer type;

    private String desc;

    WorkflowNodeTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
