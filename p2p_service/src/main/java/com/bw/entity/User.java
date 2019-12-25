package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//用户表
public class User {

    Integer id;

    String userUsername;//用户名
    String userPassword;//密码
    String userPhone;//手机号
    String userMicroblog;//微博
    String userPresenter;//推荐人
    String userVip;//会员种类
    String userStatus;//用户状态
    String userEmail;//邮箱
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date userRegtime;//注册时间
    String userAddress;//用户地址

    public User(Object[] toObjectArray, Object[] toObjectArray1) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMicroblog() {
        return userMicroblog;
    }

    public void setUserMicroblog(String userMicroblog) {
        this.userMicroblog = userMicroblog;
    }

    public String getUserPresenter() {
        return userPresenter;
    }

    public void setUserPresenter(String userPresenter) {
        this.userPresenter = userPresenter;
    }

    public String getUserVip() {
        return userVip;
    }

    public void setUserVip(String userVip) {
        this.userVip = userVip;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserRegtime() {
        return userRegtime;
    }

    public void setUserRegtime(Date userRegtime) {
        this.userRegtime = userRegtime;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userUsername='" + userUsername + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userMicroblog='" + userMicroblog + '\'' +
                ", userPresenter='" + userPresenter + '\'' +
                ", userVip='" + userVip + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRegtime=" + userRegtime +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
