package com.chen.enums;

/**
 * @description 租借记录状态枚举
 *
 * @date 2022/04/09
 */
public enum BorrowRecordStateEnum {
    UN_APPROVE(0, "租借中"),

    BORROW_SUCCESS(1, "租借成功"),

    RETURN(2, "已归还"),

    BORROW_FAIL(3, "租借失败")

    ;

    private int state;

    private String desc;

    BorrowRecordStateEnum(int state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public int getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }
}
