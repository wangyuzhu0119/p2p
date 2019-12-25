package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class LoanMark {

    //主键id
    private Integer borrowSignId;

    //借款标名称
    private String borrowName;

    //贷款人id
    private Integer borrowUserId;

    //贷款金额
    private BigDecimal borrowMoney;

    //年化利率
    private BigDecimal yearRate;

    //还款方式
    private Integer returnMoneyType;

    //总利息
    private BigDecimal interestAmont;

    //还款期数
    private Integer returnMonthes;

    //借款用途
    private String borrowUse;

    //还款天数
    private String paymentMethod;

    //招标天数
    private String borrowDays;

    //已经募集到的资金金额
    private BigDecimal accessMoney;

    //发布时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishTime;

    //借款标状态
    private Integer status;

    public Integer getBorrowSignId() {
        return borrowSignId;
    }

    public void setBorrowSignId(Integer borrowSignId) {
        this.borrowSignId = borrowSignId;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public Integer getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(Integer borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public BigDecimal getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(BigDecimal borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    public Integer getReturnMoneyType() {
        return returnMoneyType;
    }

    public void setReturnMoneyType(Integer returnMoneyType) {
        this.returnMoneyType = returnMoneyType;
    }

    public BigDecimal getInterestAmont() {
        return interestAmont;
    }

    public void setInterestAmont(BigDecimal interestAmont) {
        this.interestAmont = interestAmont;
    }

    public Integer getReturnMonthes() {
        return returnMonthes;
    }

    public void setReturnMonthes(Integer returnMonthes) {
        this.returnMonthes = returnMonthes;
    }

    public String getBorrowUse() {
        return borrowUse;
    }

    public void setBorrowUse(String borrowUse) {
        this.borrowUse = borrowUse;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBorrowDays() {
        return borrowDays;
    }

    public void setBorrowDays(String borrowDays) {
        this.borrowDays = borrowDays;
    }

    public BigDecimal getAccessMoney() {
        return accessMoney;
    }

    public void setAccessMoney(BigDecimal accessMoney) {
        this.accessMoney = accessMoney;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoanMark{" +
                "borrowSignId=" + borrowSignId +
                ", borrowName='" + borrowName + '\'' +
                ", borrowUserId=" + borrowUserId +
                ", borrowMoney=" + borrowMoney +
                ", yearRate=" + yearRate +
                ", returnMoneyType=" + returnMoneyType +
                ", interestAmont=" + interestAmont +
                ", returnMonthes=" + returnMonthes +
                ", borrowUse='" + borrowUse + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", borrowDays='" + borrowDays + '\'' +
                ", accessMoney=" + accessMoney +
                ", publishTime=" + publishTime +
                ", status=" + status +
                '}';
    }
}
