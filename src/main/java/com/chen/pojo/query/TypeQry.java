package com.chen.pojo.query;

import com.chen.pojo.ToyType;

public class TypeQry extends ToyType {

    private Integer pageNum;

    private Integer pageSize;

    @Override
    public String toString() {
        return "TypeQry{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
