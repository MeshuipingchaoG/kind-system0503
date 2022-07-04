package com.chen.enums;

/**
 * @description 审核操作类型枚举
 *
 * @date 2022/04/10
 */
public enum ApproveTypeStatusEnum {

    REJECT("reject", "驳回"),

    PASS("pass", "通过"),

    ;

    private String type;

    private String desc;

    ApproveTypeStatusEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
