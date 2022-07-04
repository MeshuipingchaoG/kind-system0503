package com.chen.pojo;

import java.util.Date;

public class BorrowRecord {

    private Integer id;
    private Integer toyId;
    private Integer userId;
    private String userName;
    private String toyName;
    private Integer btoyNum;
    private String picture;
    private Date bdate;
    private Date rdate;
    private Integer state;

    @Override
    public String toString() {
        return "WaterList{" +
                "id=" + id +
                ", toyId=" + toyId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", toyName='" + toyName + '\'' +
                ", btoyNum=" + btoyNum +
                ", picture='" + picture + '\'' +
                ", bdate=" + bdate +
                ", rdate=" + rdate +
                ", state=" + state +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getToyId() {
        return toyId;
    }

    public void setToyId(Integer toyId) {
        this.toyId = toyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public Integer getBtoyNum() {
        return btoyNum;
    }

    public void setBtoyNum(Integer btoyNum) {
        this.btoyNum = btoyNum;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BorrowRecord(Integer id, Integer toyId, Integer userId, String userName, String toyName, Integer btoyNum, String picture, Date bdate, Date rdate, Integer state) {
        this.id = id;
        this.toyId = toyId;
        this.userId = userId;
        this.userName = userName;
        this.toyName = toyName;
        this.btoyNum = btoyNum;
        this.picture = picture;
        this.bdate = bdate;
        this.rdate = rdate;
        this.state = state;
    }

    public BorrowRecord() {
    }
}
