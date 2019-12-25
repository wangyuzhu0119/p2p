package com.bw.controller;

import com.bw.entity.Account;
import com.bw.entity.AccountFlow;
import com.bw.entity.LoanMark;
import com.bw.entity.User;
import com.bw.service.UserBidService;
import com.bw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/bid")
public class UserBidController {

    @Autowired
    UserBidService userBidService;

    @Autowired
    UserService userService;

    /**
     * 1、对出借人的账户进行修改 可用余额下降  冻结金额增长
     * 2、账户记录表 t_account_flow 对 出借人的账户进行记录
     * 3、投标记录表 t_bid 对这次操作进行记录
     * 4、判断是否满标 满标的话  修改status=2
     * 5、对借款标表 t_loan_mark 进行修改 修改募集到的资金
     */

    @RequestMapping("/bidding")
    public Boolean updateAccount(@RequestBody LoanMark loanMark, String username, BigDecimal domoney , String remarks){
        System.out.println("((((((((((((((((((((((((("+loanMark);
        System.out.println("((((((((((((((((((((((((("+username);
        System.out.println("((((((((((((((((((((((((("+domoney);
        System.out.println("((((((((((((((((((((((((("+remarks);
        User user = userBidService.getByUsername(username);
        Integer id = user.getId();   //出借人的 id
        Account account = userBidService.userAccount(id);   //出借人的账户
        Integer userAccountId = account.getId();   //出借人账户的id
        try{
            //修改出借人的账户
                    //出借人的可用余额    当前的可用余额 av - 投标的钱 domoney
            BigDecimal av = account.getAccoubtAvbalance();
            BigDecimal newaccoubtavbalance = av.subtract(domoney);
                    //出借人的冻结资金  当前账户的冻结资金 af + 投标的钱 domoney
            BigDecimal af = account.getAccoubtFrobalance();
            BigDecimal newaccoubtfrobalance = af.add(af);
            userBidService.updateaccount(userAccountId,newaccoubtavbalance,newaccoubtfrobalance);

            //账户记录表 t_account_flow 对 出借人的账户进行记录       结余  可用余额

            Date recordDate = new Date();
            Integer recordHandletype = 0;
            BigDecimal recordHandlemoney = domoney;
            Integer accountId = userAccountId;
            String recordNotes = remarks;
            userBidService.insertAccountFlow(recordDate,recordHandletype,recordHandlemoney,accountId,recordNotes);

            //投标记录表 t_bid_record 对这次操作进行记录
            int borrowid = loanMark.getBorrowSignId();
            String borrowname = loanMark.getBorrowName();
            BigDecimal yearrate = loanMark.getYearRate();
            int borrowuserid = loanMark.getBorrowUserId();
            Date bidtime = new Date();
            int biduserId = id;
            BigDecimal bidmoney = domoney;
            userBidService.insertBidRecord(borrowid,borrowname,yearrate,borrowuserid,bidtime,biduserId,bidmoney);

            //判断是否满标 满标的话  修改status=2
                    //借款标需要的贷款金额
            BigDecimal borrowMoney = loanMark.getBorrowMoney();
                    //当前借款标 募集到的金额
            BigDecimal newaccessMoney = loanMark.getAccessMoney();
                    // 出借人出借的钱 + 当前已经募集到的钱
            BigDecimal addaccessMoney = domoney.add(newaccessMoney);
                    //BigDecimal的compareTo方法来进行比较。返回的结果是int类型,-1表示小于,0是等于,1是大于
            if ( addaccessMoney.compareTo(borrowMoney) == -1){
                //对借款标表 t_loan_mark 进行修改 修改募集到的资金
                userBidService.updateLoanMark(borrowid,addaccessMoney);
                return true;
            }else if(addaccessMoney.compareTo(borrowMoney) == 0){
                userBidService.updateLoanMark(borrowid,addaccessMoney);
                ////修改募集到的钱 并且 修改状态为满标待审核
                userBidService.updateStatus(borrowid);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //借款标详情
    @RequestMapping("/doloadBid")
    public LoanMark doloadBid(Integer id){
        LoanMark list = userBidService.doloadBid(id);
        return list;
    }


    //余额判断
    @RequestMapping("/checkmoney")
    public Boolean checkmoney(BigDecimal domoney , Integer id){
        //查询登录人的账户
        Account account = userBidService.getAccountById(id);
        BigDecimal av = account.getAccoubtAvbalance();
        try {
            if(domoney.compareTo(av) <= 0 ){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }




}