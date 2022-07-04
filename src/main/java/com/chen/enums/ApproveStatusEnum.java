package com.chen.enums;

/**
 * @description 审核状态枚举
 *
 * @date 2022/04/10
 */
public enum ApproveStatusEnum {

    UN_APPROVE(0, "未审核"),

    PASS(1, "审核通过"),

    REJECT(2, "审核驳回"),

    ;

    private Integer status;

    private String desc;

    ApproveStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
