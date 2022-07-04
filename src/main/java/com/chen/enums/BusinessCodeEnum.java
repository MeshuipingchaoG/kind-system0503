package com.chen.enums;

/**
 * @description 业务类型枚举
 *
 * @date 2022/04/09
 */
public enum BusinessCodeEnum {
    TOY_BORROW("TOY_BORROW", "教具租借"),

    TOY_BUY_APPLY("TOY_BUY_APPLY", "教具购买申请"),

    ;

    private String businessCode;

    private String desc;

    BusinessCodeEnum(String businessCode, String desc) {
        this.businessCode = businessCode;
        this.desc = desc;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public String getDesc() {
        return desc;
    }
}
