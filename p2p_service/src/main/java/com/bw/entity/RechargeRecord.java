package com.bw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class RechargeRecord {

    //主键 支付单号
    private Integer payId;

    //支付金额
    private BigDecimal payMoney;

    //下单时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date downOrderTime;

    //支付时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date payTime;

    //支付方式
    private Integer chargeType;

    //交易编号
    private String tradeCode;

    //付款单备注
    private String payComment;

    //支付状态
    private String payStatus;

    //用户ID
    private Integer createUserId;

    //审核人id
    private Integer auditUserId;

    //审核状态
    private Integer auditStatue;

    //审核批注
    private String auditComment;

    //审核时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date auditTime;


    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Date getDownOrderTime() {
        return downOrderTime;
    }

    public void setDownOrderTime(Date downOrderTime) {
        this.downOrderTime = downOrderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getPayComment() {
        return payComment;
    }

    public void setPayComment(String payComment) {
        this.payComment = payComment;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Integer getAuditStatue() {
        return auditStatue;
    }

    public void setAuditStatue(Integer auditStatue) {
        this.auditStatue = auditStatue;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public String toString() {
        return "RechargeRecord{" +
                "payId=" + payId +
                ", payMoney=" + payMoney +
                ", downOrderTime=" + downOrderTime +
                ", payTime=" + payTime +
                ", chargeType=" + chargeType +
                ", tradeCode='" + tradeCode + '\'' +
                ", payComment='" + payComment + '\'' +
                ", payStatus='" + payStatus + '\'' +
                ", createUserId=" + createUserId +
                ", auditUserId=" + auditUserId +
                ", auditStatue=" + auditStatue +
                ", auditComment='" + auditComment + '\'' +
                ", auditTime=" + auditTime +
                '}';
    }
}
