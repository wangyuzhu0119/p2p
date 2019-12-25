package com.bw.entity;

import java.math.BigDecimal;

public class Account {

    //主键 关联用户表
    private Integer id;

    //账户可用余额
    private BigDecimal accoubtAvbalance;

    //账户冻结资金
    private BigDecimal accoubtFrobalance;

    //待收本金
    private BigDecimal unreceivePrincipal;

    //待收本息
    private BigDecimal unreceiveInterest;

    //待还本息
    private BigDecimal unreceiveMoney;

    //授信额度
    private BigDecimal creditLimit;

    //剩余授信额度
    private BigDecimal remainCreditLimit;

    //交易密码
    private String tradePassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAccoubtAvbalance() {
        return accoubtAvbalance;
    }

    public void setAccoubtAvbalance(BigDecimal accoubtAvbalance) {
        this.accoubtAvbalance = accoubtAvbalance;
    }

    public BigDecimal getAccoubtFrobalance() {
        return accoubtFrobalance;
    }

    public void setAccoubtFrobalance(BigDecimal accoubtFrobalance) {
        this.accoubtFrobalance = accoubtFrobalance;
    }

    public BigDecimal getUnreceivePrincipal() {
        return unreceivePrincipal;
    }

    public void setUnreceivePrincipal(BigDecimal unreceivePrincipal) {
        this.unreceivePrincipal = unreceivePrincipal;
    }

    public BigDecimal getUnreceiveInterest() {
        return unreceiveInterest;
    }

    public void setUnreceiveInterest(BigDecimal unreceiveInterest) {
        this.unreceiveInterest = unreceiveInterest;
    }

    public BigDecimal getUnreceiveMoney() {
        return unreceiveMoney;
    }

    public void setUnreceiveMoney(BigDecimal unreceiveMoney) {
        this.unreceiveMoney = unreceiveMoney;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getRemainCreditLimit() {
        return remainCreditLimit;
    }

    public void setRemainCreditLimit(BigDecimal remainCreditLimit) {
        this.remainCreditLimit = remainCreditLimit;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accoubtAvbalance=" + accoubtAvbalance +
                ", accoubtFrobalance=" + accoubtFrobalance +
                ", unreceivePrincipal=" + unreceivePrincipal +
                ", unreceiveInterest=" + unreceiveInterest +
                ", unreceiveMoney=" + unreceiveMoney +
                ", creditLimit=" + creditLimit +
                ", remainCreditLimit=" + remainCreditLimit +
                ", tradePassword='" + tradePassword + '\'' +
                '}';
    }
}
