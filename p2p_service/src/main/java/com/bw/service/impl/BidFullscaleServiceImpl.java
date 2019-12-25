package com.bw.service.impl;

import com.bw.entity.Account;
import com.bw.entity.BidRecord;
import com.bw.entity.LoanMark;
import com.bw.entity.ReturnPlan;
import com.bw.mapper.BidFullscaleMapper;
import com.bw.service.BidFullscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BidFullscaleServiceImpl implements BidFullscaleService {

    @Autowired
    BidFullscaleMapper bidFullscaleMapper;

    //满标列表
    @Override
    public List<LoanMark> fullscaleList() {
        return bidFullscaleMapper.fullscaleList();
    }

    //满标审核不予通过
    @Override
    public void checkFail(Integer borrowSignId,Integer checkid,Date checkDate,String comment) {
        bidFullscaleMapper.checkFail(borrowSignId,checkid,checkDate,comment);
    }

    //向满标审核表t_borrow_audit_record插入审核记录
    @Override
    public void insertScaleRecord(Integer borrowSignId, Integer checkid, Date checkDate, String comment) {
        bidFullscaleMapper.insertScaleRecord(borrowSignId, checkid, checkDate, comment);
    }

    //修改借款标t_loan_mark中的状态为还款中
    @Override
    public void updateStstus(Integer borrowSignId) {
        bidFullscaleMapper.updateStstus(borrowSignId);
    }

    /**
     * 获取申请人的账户信息
     * @param borrowSignId
     * @return
     */
    @Override
    public LoanMark getBorrowLoanMark(Integer borrowSignId) {
        return bidFullscaleMapper.getBorrowLoanMark(borrowSignId);
    }
    @Override
    public Account getBorrowAccount(Integer borrowUsersId) {
        return bidFullscaleMapper.getBorrowAccount(borrowUsersId);
    }

    //借款人可用余额增加
    @Override
    public void updateBorrowUserAV(BigDecimal newAV,BigDecimal newIntamont,Integer borrowUserid) {
        bidFullscaleMapper.updateBorrowUserAV(newAV,newIntamont,borrowUserid);
    }

    //根据借款标的id查询 所有投该标的信息
    @Override
    public List<BidRecord> getBidRecordListById(Integer borrowSignId) {
        return bidFullscaleMapper.getBidRecordListById(borrowSignId);
    }



    //循环 修改出借人的账户
    @Override
    public void updateBidUserUP(Integer bidUserId, BigDecimal bidUserUI, BigDecimal BidUserAF, BigDecimal bidMoney) {
        bidFullscaleMapper.updateBidUserUP(bidUserId, bidUserUI, BidUserAF, bidMoney);
    }

    //出借人的账户
    @Override
    public Account getBidUserAccountById(Integer bidUserId) {
        return bidFullscaleMapper.getBidUserAccountById(bidUserId);
    }

    //借款人借到款  可用余额增加 添加一条动账信息
    @Override
    public void insertAccountFlow(Integer borrowUserid, Date recordDate, BigDecimal accountFlowMoney, BigDecimal newAV) {
        bidFullscaleMapper.insertAccountFlow(borrowUserid, recordDate, accountFlowMoney, newAV);
    }

    //循环添加 出借人的动账记录
    @Override
    public void BidUserAccountFlow(Integer bidUserId, Date BidRecordDate, BigDecimal bidMoney, BigDecimal BidUserAF) {
        bidFullscaleMapper.BidUserAccountFlow(bidUserId, BidRecordDate, bidMoney, BidUserAF);
    }

    //添加还款计划
    @Override
    public void insertReturnPlan(Integer borrowId, String borrowName, Integer returnMonthe, Integer borrowUserId, BigDecimal returnMoney, BigDecimal returnPrincipal, BigDecimal interestAmont, Date returnDate) {
        bidFullscaleMapper.insertReturnPlan(borrowId, borrowName, returnMonthe, borrowUserId, returnMoney, returnPrincipal, interestAmont, returnDate);
    }

    //获取这一期的还款计划
    @Override
    public ReturnPlan getReturnPlan(Integer returnMonthe) {
        return bidFullscaleMapper.getReturnPlan(returnMonthe);
    }

    //添加回款计划
    @Override
    public void insertRecordPlan(Integer returnPlanid, Integer borrowId, String borrowName, Integer returnMonthe, BigDecimal receiveMoney, BigDecimal receivePal, BigDecimal interestFee, Integer borrowUserId, Date receiveDate) {
        bidFullscaleMapper.insertRecordPlan(returnPlanid, borrowId, borrowName, returnMonthe, receiveMoney, receivePal, interestFee, borrowUserId, receiveDate);
    }


}
