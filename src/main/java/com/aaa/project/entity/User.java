package com.aaa.project.entity;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 19:09
 * @description: Exercise
 * @Version 1.0.0
 */
public class User {
    private Integer userId;
    private String userName;
    private String loginAccount;
    private String loginPassword;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer userId, String userName, String loginAccount, String loginPassword) {
        this.userId = userId;
        this.userName = userName;
        this.loginAccount = loginAccount;
        this.loginPassword = loginPassword;
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

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
