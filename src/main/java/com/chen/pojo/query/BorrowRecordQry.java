package com.chen.pojo.query;

import com.chen.pojo.BorrowToy;

public class BorrowRecordQry extends BorrowToy {
    private Integer pageNum;

    private Integer pageSize;

    @Override
    public String toString() {
        return "BorrowRecordQry{" +
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
