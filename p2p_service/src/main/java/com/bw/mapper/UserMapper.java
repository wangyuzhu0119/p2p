package com.bw.mapper;

import com.bw.entity.Account;
import com.bw.entity.BidRecord;
import com.bw.entity.LoanMark;
import com.bw.entity.User;
import com.sun.org.apache.bcel.internal.generic.LMUL;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;


@Mapper
public interface UserMapper {
    //登录
    User login(String username);

    //用户个人中心
    User selUserByName(String username);

    //注册
    Boolean insertUser(User user);

    //查询所有普通用户
    List<User> loadOrdinaryUser();

    //查询所有企业会员
    List<User> loadEnterpriseUser();

    //查询黑名单
    List<User> loadBlacklist();

    //某个用户的信息 按照ID查找
    User doloadUserById(Integer id);

    //t通过ID拉黑用户
    Boolean addBlackListById(Integer id);

    //注册新用户--建立一个新账户
    void insertAccount(Integer id);

    //查询账户 按照ID
    Account doloadAccountById(Integer id);

    //申请借款
    Boolean addApplyForLoan(LoanMark loanMark);

    //查询未审核的借款标
    List getLoanMark();

    //查询正在招标中
    List<LoanMark> getbidding();

    //借款标审核通过
    Boolean loanpass(Integer id);

    Boolean renewuser(Integer id);
}