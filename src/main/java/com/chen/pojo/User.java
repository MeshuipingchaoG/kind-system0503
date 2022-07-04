package com.chen.pojo;

public class User {
    private Integer id;
    private String aname;
    private String apwd;
    private Integer role;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", aname='" + aname + '\'' +
                ", apwd='" + apwd + '\'' +
                ", role=" + role +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public User(Integer id, String aname, String apwd, Integer role) {
        this.id = id;
        this.aname = aname;
        this.apwd = apwd;
        this.role = role;
    }

    public User() {
    }
}
