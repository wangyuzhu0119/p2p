package com.bw.service.impl;

import com.bw.entity.Account;
import com.bw.entity.LoanMark;
import com.bw.entity.User;
import com.bw.mapper.UserBidMapper;
import com.bw.service.UserBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class UserBidServiceImpl implements UserBidService {

    @Autowired
    UserBidMapper userBidMapper;

    //查询该用户的账户
    @Override
    public Account userAccount(Integer id) {
        return userBidMapper.userAccount(id);
    }

    //修改出借人的账户
    @Override
    public void updateaccount(Integer userAccountId , BigDecimal newaccoubtavbalance, BigDecimal newaccoubtfrobalance) {
        userBidMapper.updateaccount(userAccountId,newaccoubtavbalance,newaccoubtfrobalance);
    }

    //账户记录表增加一条信息
    @Override
    public void insertAccountFlow(Date recordDate, Integer recordHandletype, BigDecimal recordHandlemoney, Integer accountId, String recordNotes) {
        userBidMapper.insertAccountFlow(recordDate, recordHandletype, recordHandlemoney, accountId, recordNotes);
    }

    //投标记录表 t_bid 对这次操作进行记录
    @Override
    public void insertBidRecord(int borrowid, String borrowname, BigDecimal yearrate, int borrowuserid, Date bidtime, int biduserId, BigDecimal bidmoney) {
        userBidMapper.insertBidRecord(borrowid, borrowname, yearrate, borrowuserid, bidtime, biduserId, bidmoney);
    }

    //对借款标表 t_loan_mark 进行修改 修改募集到的资金
    @Override
    public void updateLoanMark(int borrowid, BigDecimal addaccessMoney) {
        userBidMapper.updateLoanMark(borrowid,addaccessMoney);
    }


    //借款标详情
    @Override
    public LoanMark doloadBid(Integer id) {
        return userBidMapper.doloadBid(id);
    }

    //查询登录人的账户
    @Override
    public Account getAccountById(Integer id) {
        return userBidMapper.getAccountById(id);
    }

    //修改status为满标审核状态
    @Override
    public void updateStatus(int borrowid) {
        userBidMapper.updateStatus(borrowid);
    }

    @Override
    public User getByUsername(String username) {
        return userBidMapper.getByUsername(username);
    }

}
