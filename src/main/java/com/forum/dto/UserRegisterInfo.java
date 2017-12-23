package com.forum.dto;

public class UserRegisterInfo {
    private String userName;
    private String password;
    private String userEmail;

    public UserRegisterInfo(){}

    public UserRegisterInfo(String userName, String password, String userEmail){
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
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

    @Override
    public String toString() {
        return "UserRegisterInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
