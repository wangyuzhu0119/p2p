package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class BidRecord {

    //投标记录主键id
    private Integer bidId;

    //借款标id
    private Integer borrowId;

    //借款标名称
    private String borrowName;

    //投资金额
    private BigDecimal bidMoney;

    //年化利率
    private String yearRate;

    //投标时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bidTime;

    //投标人id
    private Integer bidUserId;

    //借款人id
    private Integer borrowUserId;

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public BigDecimal getBidMoney() {
        return bidMoney;
    }

    public void setBidMoney(BigDecimal bidMoney) {
        this.bidMoney = bidMoney;
    }

    public String getYearRate() {
        return yearRate;
    }

    public void setYearRate(String yearRate) {
        this.yearRate = yearRate;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public Integer getBidUserId() {
        return bidUserId;
    }

    public void setBidUserId(Integer bidUserId) {
        this.bidUserId = bidUserId;
    }

    public Integer getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(Integer borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    @Override
    public String toString() {
        return "BidRecord{" +
                "bidId=" + bidId +
                ", borrowId=" + borrowId +
                ", borrowName='" + borrowName + '\'' +
                ", bidMoney=" + bidMoney +
                ", yearRate='" + yearRate + '\'' +
                ", bidTime=" + bidTime +
                ", bidUserId=" + bidUserId +
                ", borrowUserId=" + borrowUserId +
                '}';
    }
}
