package com.bw.service.impl;

import com.bw.entity.Account;
import com.bw.entity.LoanMark;
import com.bw.entity.User;
import com.bw.mapper.UserMapper;
import com.bw.service.RedisService;
import com.bw.service.UserService;
import com.bw.utils.CookieUtil;
import com.bw.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RedisService redisService;
    @Autowired
    UserMapper userMapper;

    //登录验证
    @Override
    public boolean doLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = userMapper.login(username);
        if (user==null){
            System.out.println("用户不存在！");
            return false;
        }
        if (!Md5Utils.md5(password).equals(user.getUserPassword())){
            System.out.println("用户或密码错误！");
            return false;
        }
        String tk = UUID.randomUUID().toString();
        redisService.set(tk,user,CookieUtil.SESSION_EXPIRE_SECONDS);
        Cookie cookie = new Cookie(CookieUtil.COOKIE_NAME_TOKEN,tk);
        cookie.setMaxAge(CookieUtil.SESSION_EXPIRE_SECONDS);
        cookie.setDomain("api.p2p.com");
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }

    @Override
    public User sso(HttpServletRequest request, HttpServletResponse response) {
        String tk = CookieUtil.getCookieValue(request, CookieUtil.COOKIE_NAME_TOKEN);
        if (tk==null||"".equals(tk)){
            return null;
        }
        User user = redisService.get(tk, User.class);
        return user;
    }

    //用户个人中心
    @Override
    public User selUserByName(String username) {
        return userMapper.selUserByName(username);
    }

    //用户注册
    @Override
    public Boolean insertUser(User user) {
        System.out.print("注册用户资料--"+user);
        String username = user.getUserUsername();
        try{
            user.setUserPassword(Md5Utils.md5(user.getUserPassword()));
            System.out.print("注册用户资料--"+user);
            userMapper.insertUser(user);
            User user1 = userMapper.login(username);
            Integer id = user1.getId();
            userMapper.insertAccount(id);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //查询所有普通用户
    @Override
    public List<User> loadOrdinaryUser() {
        return userMapper.loadOrdinaryUser();
    }

    //查询所有企业会员
    @Override
    public List<User> loadEnterpriseUser() {
        return userMapper.loadEnterpriseUser();
    }

    //查询黑名单
    @Override
    public List<User> loadBlacklist() {
        return userMapper.loadBlacklist();
    }

    //某个用户的信息 按照ID查找
    @Override
    public User doloadUserById(Integer id) {
        return userMapper.doloadUserById(id);
    }

    //t通过ID拉黑用户
    @Override
    public Boolean addBlackListById(Integer id) {
        return userMapper.addBlackListById(id);
    }

    //账户
    @Override
    public Account doloadAccountById(Integer id) {
        return userMapper.doloadAccountById(id);
    }

    @Override
    public Boolean addApplyForLoan(LoanMark loanMark) {
        return userMapper.addApplyForLoan(loanMark);
    }

    //查询招标待审核
    @Override
    public List getLoanMark() {
        return userMapper.getLoanMark();
    }

    //正在招标中
    @Override
    public List<LoanMark> getbidding() {
        return userMapper.getbidding();
    }

    //借款标审核通过
    @Override
    public Boolean loanpass(Integer id) {
        return userMapper.loanpass(id);
    }

    @Override
    public Boolean renewuser(Integer id) {
        return userMapper.renewuser(id);
    }

}
