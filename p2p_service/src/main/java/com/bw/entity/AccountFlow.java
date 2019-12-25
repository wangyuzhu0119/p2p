package com.bw.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AccountFlow {

    //主键id
    private Integer recordId;

    //动账时间
    private Date recordDate;

    //操作类型
    private Integer recordHandletype;

    //操作金额
    private BigDecimal recordHandlemoney;

    //对应账户id
    private Integer accountId;

    //结余
    private BigDecimal recordSurplus;

    //备注
    private String recordNotes;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getRecordHandletype() {
        return recordHandletype;
    }

    public void setRecordHandletype(Integer recordHandletype) {
        this.recordHandletype = recordHandletype;
    }

    public BigDecimal getRecordHandlemoney() {
        return recordHandlemoney;
    }

    public void setRecordHandlemoney(BigDecimal recordHandlemoney) {
        this.recordHandlemoney = recordHandlemoney;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getRecordSurplus() {
        return recordSurplus;
    }

    public void setRecordSurplus(BigDecimal recordSurplus) {
        this.recordSurplus = recordSurplus;
    }

    public String getRecordNotes() {
        return recordNotes;
    }

    public void setRecordNotes(String recordNotes) {
        this.recordNotes = recordNotes;
    }

    @Override
    public String toString() {
        return "AccountFlow{" +
                "recordId=" + recordId +
                ", recordDate=" + recordDate +
                ", recordHandletype=" + recordHandletype +
                ", recordHandlemoney=" + recordHandlemoney +
                ", accountId=" + accountId +
                ", recordSurplus=" + recordSurplus +
                ", recordNotes='" + recordNotes + '\'' +
                '}';
    }
}
