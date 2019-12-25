package com.bw.mapper;

import com.bw.entity.Account;
import com.bw.entity.LoanMark;
import com.bw.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Date;

@Mapper
public interface UserBidMapper {

    //查询该用户的账户
    Account userAccount(Integer id);

    //修改出借人的账户
    void updateaccount(Integer userAccountId,BigDecimal newaccoubtavbalance, BigDecimal newaccoubtfrobalance);

    //账户记录表 增加一条信息
    void insertAccountFlow(Date recordDate, Integer recordHandletype, BigDecimal recordHandlemoney, Integer accountId, String recordNotes);

    //投标记录表 t_bid 对这次操作进行记录
    void insertBidRecord(int borrowid, String borrowname, BigDecimal yearrate, int borrowuserid, Date bidtime, int biduserId, BigDecimal bidmoney);

    //对借款标表 t_loan_mark 进行修改 修改募集到的资金
    void updateLoanMark(int borrowid, BigDecimal addaccessMoney);

    //借款标详情
    LoanMark doloadBid(Integer id);

    //查询登录人的账户
    Account getAccountById(Integer id);

    //修改status 为满标审核状态
    void updateStatus(int borrowid);

    User getByUsername(String username);
}
