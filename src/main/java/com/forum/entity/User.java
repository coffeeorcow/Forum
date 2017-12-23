package com.forum.entity;

import java.util.Date;

public class User {
    private Long userId;  // 用户id
    private String userName;  // 用户名
    private String password;  // 密码
    private String userEmail;  // 用户email
    private Date createTime;  // 用户开户时间
    private int userType;  // 用户类型  0普通用户  1管理员用户
    private int userState;  // 用户激活状态：0封锁  1激活
    private Date lastLoginTime;  // 最后一次登录时间

    public User(){

    }

    public User(String userName, String password, String userEmail) {
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", createTime=" + createTime +
                ", userType=" + userType +
                ", userState=" + userState +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
