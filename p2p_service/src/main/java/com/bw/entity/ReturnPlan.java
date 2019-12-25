package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ReturnPlan {

    private Integer id;
    private Integer borrowId;
    private String loanName;
    private Integer phase;
    private Integer returnUserId;
    private BigDecimal returnMoney;
    private BigDecimal returnPrincipal;
    private BigDecimal returnInterest;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnDeadline;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnTime;
    private Integer returnStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Integer getReturnUserId() {
        return returnUserId;
    }

    public void setReturnUserId(Integer returnUserId) {
        this.returnUserId = returnUserId;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public BigDecimal getReturnPrincipal() {
        return returnPrincipal;
    }

    public void setReturnPrincipal(BigDecimal returnPrincipal) {
        this.returnPrincipal = returnPrincipal;
    }

    public BigDecimal getReturnInterest() {
        return returnInterest;
    }

    public void setReturnInterest(BigDecimal returnInterest) {
        this.returnInterest = returnInterest;
    }

    public Date getReturnDeadline() {
        return returnDeadline;
    }

    public void setReturnDeadline(Date returnDeadline) {
        this.returnDeadline = returnDeadline;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    @Override
    public String toString() {
        return "ReturnPlan{" +
                "id=" + id +
                ", borrowId=" + borrowId +
                ", loanName='" + loanName + '\'' +
                ", phase=" + phase +
                ", returnUserId=" + returnUserId +
                ", returnMoney=" + returnMoney +
                ", returnPrincipal=" + returnPrincipal +
                ", returnInterest=" + returnInterest +
                ", returnDeadline=" + returnDeadline +
                ", returnTime=" + returnTime +
                ", returnStatus=" + returnStatus +
                '}';
    }
}
