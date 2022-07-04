package com.chen.pojo.query;

import com.chen.pojo.BorrowRecord;

public class RecordQry extends BorrowRecord {

    private Integer pageNum;

    private Integer pageSize;

    @Override
    public String toString() {
        return "RecordQry{" +
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
