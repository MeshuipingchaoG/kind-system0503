package com.chen.pojo;

public class Teacher {
    private Integer id;
    private String userName;
    private String userPwd;
    private String phone;
    private Integer role;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Teacher(Integer id, String userName, String userPwd, String phone, Integer role) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.phone = phone;
        this.role = role;
    }

    public Teacher() {
    }
}
