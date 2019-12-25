package com.bw.entity;

import java.util.Date;

public class BorrowAuditRecord {

    //审核id
    private Integer id;

    //借款标id
    private Integer borrowId;

    //审核类型
    private Integer auditType;

    //审核结果状态
    private Integer audit_status;

    //审核批注
    private String audit_comment;

    //审核人id
    private Integer audit_user_id;

    //审核时间
    private Date auditTime;

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

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Integer getAudit_status() {
        return audit_status;
    }

    public void setAudit_status(Integer audit_status) {
        this.audit_status = audit_status;
    }

    public String getAudit_comment() {
        return audit_comment;
    }

    public void setAudit_comment(String audit_comment) {
        this.audit_comment = audit_comment;
    }

    public Integer getAudit_user_id() {
        return audit_user_id;
    }

    public void setAudit_user_id(Integer audit_user_id) {
        this.audit_user_id = audit_user_id;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public String toString() {
        return "BorrowAuditRecord{" +
                "id=" + id +
                ", borrowId=" + borrowId +
                ", auditType=" + auditType +
                ", audit_status=" + audit_status +
                ", audit_comment='" + audit_comment + '\'' +
                ", audit_user_id=" + audit_user_id +
                ", auditTime=" + auditTime +
                '}';
    }
}