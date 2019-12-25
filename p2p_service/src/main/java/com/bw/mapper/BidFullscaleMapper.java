package com.bw.mapper;

import com.bw.entity.Account;
import com.bw.entity.BidRecord;
import com.bw.entity.LoanMark;
import com.bw.entity.ReturnPlan;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
public interface BidFullscaleMapper {

    //满标列表
    List<LoanMark> fullscaleList();

    //满标审核不予通过
    void checkFail(Integer borrowSignId,Integer checkid,Date checkDate,String comment);

    //向满标审核表t_borrow_audit_record插入审核记录
    void insertScaleRecord(Integer borrowSignId, Integer checkid, Date checkDate, String comment);

    ///修改借款标t_loan_mark中的状态为还款中
    void updateStstus(Integer borrowSignId);

    //获取申请人的账户信息
    LoanMark getBorrowLoanMark(Integer borrowSignId);
    Account getBorrowAccount(Integer borrowUsersId);

    //借款人可用余额增加
    void updateBorrowUserAV(BigDecimal newAV,BigDecimal newIntamont,Integer borrowUserid);

    //根据借款标的id查询 所有投该标的信息
    List<BidRecord> getBidRecordListById(Integer borrowSignId);

    //循环 修改出借人的账户
    void updateBidUserUP(Integer bidUserId,BigDecimal bidUserUI, BigDecimal BidUserAF,BigDecimal bidMoney);

    //出借人的账户
    Account getBidUserAccountById(Integer bidUserId);

    //借款人借到款  可用余额增加 添加一条动账信息
    void insertAccountFlow(Integer borrowUserid, Date recordDate, BigDecimal accountFlowMoney, BigDecimal newAV);

    //循环添加 出借人的动账记录
    void BidUserAccountFlow(Integer bidUserId, Date bidRecordDate, BigDecimal bidMoney, BigDecimal bidUserAF);

    //添加还款计划
    void insertReturnPlan(Integer borrowId, String borrowName, Integer returnMonthe, Integer borrowUserId, BigDecimal returnMoney, BigDecimal returnPrincipal, BigDecimal interestAmont, Date returnDate);

    //获取这一期的还款计划
    ReturnPlan getReturnPlan(Integer returnMonthe);

    //添加回款计划
    void insertRecordPlan(Integer returnPlanid, Integer borrowId, String borrowName, Integer returnMonthe, BigDecimal receiveMoney, BigDecimal receivePal, BigDecimal interestFee, Integer borrowUserId, Date receiveDate);

}
