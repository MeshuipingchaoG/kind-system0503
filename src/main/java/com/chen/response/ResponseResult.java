package com.chen.response;

import java.util.List;

/**
 * @date 2022/04/29
 */
public class ResponseResult<T> {

    /**
     * 1：成功
     * 0: 失败
     */
    private int status;

    private T data;

    private String msg;

    public ResponseResult(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
