package com.lujun61.entity;

public class Users {
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private String sex;

    public Users() {
    }

    public Users(Integer userId, String usrName, String password, String email, String sex) {
        this.userId = userId;
        this.userName = usrName;
        this.password = password;
        this.email = email;
        this.sex = sex;
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

    public void setUserName(String usrName) {
        this.userName = usrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
