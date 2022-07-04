package com.chen.pojo;

public class BorrowToy {
    /**
     * 教具id
     */
    private Integer id;

    /**
     * 借的数量
     */
    private Integer btoyNum;

    @Override
    public String toString() {
        return "BorrowToy{" +
                "id=" + id +
                ", btoyNum=" + btoyNum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBtoyNum() {
        return btoyNum;
    }

    public void setBtoyNum(Integer btoyNum) {
        this.btoyNum = btoyNum;
    }
}
