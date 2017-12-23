package com.forum.dto;

/**
 * 用户登录信息
 */
public class UserInfo {
    private Long userId;  // 用户id
    private String userName;  // 用户名
    private int userType;  // 用户类型

    public UserInfo() {
    }

    public UserInfo(Long userId, String userName){
        this.userId = userId;
        this.userName = userName;
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userType=" + userType +
                '}';
    }
}
