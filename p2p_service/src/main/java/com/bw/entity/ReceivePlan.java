package com.bw.entity;

import java.math.BigDecimal;

public class ReceivePlan {

    //收款计划id
    private Integer id;

    //还款标id
    private Integer returnId;

    //借款标id
    private Integer borrowId;

    //贷款名称/主题
    private String loanName;

    //第几期
    private String phase;

    //收款总金额
    private BigDecimal receiveMoney;

    //收款利率
    private String receiveInterest;

    //收款本金
    private String receivePrincipal;

    //利息管理费
    private String interestFee;

    //回款人id
    private String receiveUserId;

    //回款日
    private String receiveDate;

    //实际回款日
    private String actualReceiveDate;

    //回款状态
    private String receiveStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public BigDecimal getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(BigDecimal receiveMoney) {
        this.receiveMoney = receiveMoney;
    }

    public String getReceiveInterest() {
        return receiveInterest;
    }

    public void setReceiveInterest(String receiveInterest) {
        this.receiveInterest = receiveInterest;
    }

    public String getReceivePrincipal() {
        return receivePrincipal;
    }

    public void setReceivePrincipal(String receivePrincipal) {
        this.receivePrincipal = receivePrincipal;
    }

    public String getInterestFee() {
        return interestFee;
    }

    public void setInterestFee(String interestFee) {
        this.interestFee = interestFee;
    }

    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getActualReceiveDate() {
        return actualReceiveDate;
    }

    public void setActualReceiveDate(String actualReceiveDate) {
        this.actualReceiveDate = actualReceiveDate;
    }

    public String getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(String receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    @Override
    public String toString() {
        return "ReceivePlan{" +
                "id=" + id +
                ", returnId=" + returnId +
                ", borrowId=" + borrowId +
                ", loanName='" + loanName + '\'' +
                ", phase='" + phase + '\'' +
                ", receiveMoney=" + receiveMoney +
                ", receiveInterest='" + receiveInterest + '\'' +
                ", receivePrincipal='" + receivePrincipal + '\'' +
                ", interestFee='" + interestFee + '\'' +
                ", receiveUserId='" + receiveUserId + '\'' +
                ", receiveDate='" + receiveDate + '\'' +
                ", actualReceiveDate='" + actualReceiveDate + '\'' +
                ", receiveStatus='" + receiveStatus + '\'' +
                '}';
    }
}
