package com.chen.utils;

import org.springframework.stereotype.Component;

/**
 * @description TODO
 *
 * @date 2022/04/10
 */
@Component
public class FormatterUtils {

    public static String borrowStateFormatter(Integer state) {
        if (state == null) {
            return "";
        }
        if (state == 0) {
            return "审批中";
        } else if (state == 1) {
            return "租借成功";
        } else if (state == 2) {
            return "租借失败";
        } else {
            return "";
        }
    }
}
