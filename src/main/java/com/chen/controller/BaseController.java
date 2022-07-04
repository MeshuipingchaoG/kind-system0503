package com.chen.controller;

import com.chen.response.ResponseResult;

import java.util.List;

/**
 */
public class BaseController<T> {

    public ResponseResult<T> writeSuccess(T t) {
        return new ResponseResult<>(1, t, null);
    }

    public ResponseResult<T> writeFail(T t, String failMsg) {
        return new ResponseResult<>(0, t, failMsg);
    }

}
