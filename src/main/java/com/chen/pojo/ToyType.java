package com.chen.pojo;

public class ToyType {
    private Integer id;
    private String typename;

    @Override
    public String toString() {
        return "ToyType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public ToyType(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public ToyType() {
    }
}
