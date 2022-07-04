package com.chen.pojo;

public class Toy {
    private Integer id;
    private Integer typeId;
    private String toyName;
    private Integer toyNum;
    private String picture;
    private String typename;

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", toyName='" + toyName + '\'' +
                ", toyNum=" + toyNum +
                ", picture='" + picture + '\'' +
                ", typename='" + typename + '\'' +
                '}';
    }

    public Toy(String typename) {
        this.typename = typename;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Toy() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public Integer getToyNum() {
        return toyNum;
    }

    public void setToyNum(Integer toyNum) {
        this.toyNum = toyNum;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Toy(Integer id, Integer typeId, String toyName, Integer toyNum, String picture) {
        this.id = id;
        this.typeId = typeId;
        this.toyName = toyName;
        this.toyNum = toyNum;
        this.picture = picture;
    }
}
