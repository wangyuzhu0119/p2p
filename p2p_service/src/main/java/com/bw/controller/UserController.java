package com.bw.controller;

import com.bw.entity.Account;
import com.bw.entity.BidRecord;
import com.bw.entity.LoanMark;
import com.bw.entity.User;
import com.bw.service.UserService;
import com.bw.utils.CalculateInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CalculateInterest calculateInterests;


    //用户个人资料
    @RequestMapping("/selUserByName")
    public User getUserListByUsername(String username){
        System.out.print("-------------------"+username);
        User user = userService.selUserByName(username);
        System.out.print("用户个人数据-"+user);
        return user;
    }


    //用户注册
    @RequestMapping("/adduser")
    public boolean addUser(@RequestBody User user){
        System.out.print("controller--"+user);
        return userService.insertUser(user);
    }

    //查询全部普通用户
    @GetMapping("/loadOrdinaryUser")
    public List<User> loadOrdinaryUser(){
        List<User> OrdinaryUser = userService.loadOrdinaryUser();
        System.out.print("普通用户信息"+OrdinaryUser);
        return  OrdinaryUser;
    }


    //查询所有企业会员
    @GetMapping("/loadEnterpriseUser")
    public List<User> loadEnterpriseUser(){
        List<User> EnterpriseUser = userService.loadEnterpriseUser();
        System.out.print("企业会员用户信息"+EnterpriseUser);
        return  EnterpriseUser;
    }

    //查询所有黑名单成员
    @GetMapping("/loadBlacklist")
    public List<User> loadBlacklist(){
        List<User> Blacklist = userService.loadBlacklist();
        System.out.print("黑名单会员信息"+Blacklist);
        return  Blacklist;
    }

    //某个用户的信息 按照ID查找
    @RequestMapping("/doloadUserById")
    public User doloadUserById(Integer id){
        System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id+"+"+userService.doloadUserById(id));
        return userService.doloadUserById(id);
    }

    //通过ID拉黑用户
    @RequestMapping("/addBlackListById")
    public Boolean addBlackListById(Integer id){
        return userService.addBlackListById(id);
    }

    @RequestMapping("/renewuser")
    public Boolean renewuser(Integer id){
        return userService.renewuser(id);
    }

    //某个用户的账户信息 按照id查找
    @RequestMapping("/doloadAccountById")
    public Account doloadUserByid(Integer id){
        System.out.print("▄▄▄▄▄▄▄▄▄"+userService.doloadAccountById(id));
        return userService.doloadAccountById(id);
    }

    //添加借款标
    @RequestMapping("/addApplyForLoan")
    public Boolean addApplyForLoan(@RequestBody LoanMark loanMark){
        String username = "wang";
        try{
            User user = userService.selUserByName(username);
            Integer buid = user.getId();
            loanMark.setBorrowUserId(buid);
            Date publishTime = new Date();
            loanMark.setPublishTime(publishTime);
            //计算利息 放入LoanMark中
            BigDecimal yearRate = new BigDecimal(6);
            loanMark.setYearRate(yearRate);
            BigDecimal borrowAmount = loanMark.getBorrowMoney();
            Integer returnMonthNum = loanMark.getReturnMonthes();
            Integer returnType = loanMark.getReturnMoneyType();
            BigDecimal interestAmont = CalculateInterest.calculateInterest(borrowAmount,yearRate,returnMonthNum,returnType);
            loanMark.setInterestAmont(interestAmont);
            userService.addApplyForLoan(loanMark);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    //利息计算
    /*
    //    borrowAmount 借款总金额
    //    yearRate 年化利率
    //    returnMonthNum 还款期数/月
    //    returnType 还款方式  0-等额本息   1-按月到期  2-等额本金
     */
    @RequestMapping("/InterestCalculation")
    public BigDecimal InterestCalculation(BigDecimal borrowAmounts,Integer returnMonthNums,Integer returnTypes){
        BigDecimal yearRate = new BigDecimal(6);
        BigDecimal borrowAmount = borrowAmounts;
        Integer returnMonthNum = returnMonthNums;
        Integer returnType = returnTypes;
        System.out.print(borrowAmount+"^^^^^"+yearRate+"^^^^^"+returnType+"^^^^^"+returnMonthNum);
        System.out.print("$$$"+CalculateInterest.calculateInterest(borrowAmount,yearRate,returnType,returnMonthNum));
        BigDecimal total = CalculateInterest.calculateInterest(borrowAmount,yearRate,returnMonthNum,returnType);
        return total;
    }

    //查询未审核的借款标
    @RequestMapping("/getLoanMark")
    public List<LoanMark> getLoanMark(){
        System.out.print(userService.getLoanMark());
        return userService.getLoanMark();
    }

    //查询正在招标中
    @RequestMapping("/getbidding")
    public List<LoanMark> getbidding(){
        System.out.print(userService.getbidding());
        List<LoanMark> bidlist = userService.getbidding();
        return bidlist;
    }

    //审核通过 loanpass
    @RequestMapping("/loanpass")
    public Boolean loanpass(Integer id){
        System.out.print("借款标审核通过-->>"+id);
        return userService.loanpass(id);
    }
}
