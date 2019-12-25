package com.bw.service;

import com.bw.entity.Account;
import com.bw.entity.BidRecord;
import com.bw.entity.LoanMark;
import com.bw.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    //登录
    public boolean doLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);

    //获取  ***
    User sso(HttpServletRequest request, HttpServletResponse response);

    //个人中心
    User selUserByName(String username);

    //注册
    Boolean insertUser(User user);

    //查询所有普通用户
    List<User> loadOrdinaryUser();

    //查询所有企业会员
    List<User> loadEnterpriseUser();

    ////查询黑名单
    List<User> loadBlacklist();

    //某个用户的信息 按照ID查找
    User doloadUserById(Integer id);

    //t通过ID拉黑用户
    Boolean addBlackListById(Integer id);

    //查询 用户个人账户信息
    Account doloadAccountById(Integer id);

    Boolean addApplyForLoan(LoanMark loanMark);

    //查询未审核的借款标
    List getLoanMark();

    //查询正在招标中
    List<LoanMark> getbidding();

    //借款标 审核通过
    Boolean loanpass(Integer id);

    //黑名单用户恢复权限
    Boolean renewuser(Integer id);

}