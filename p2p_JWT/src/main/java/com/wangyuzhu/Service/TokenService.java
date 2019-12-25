package com.wangyuzhu.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.wangyuzhu.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));  // 将 user id 保存到 token 里面// 以 password 作为 token 的密钥
        return token;
    }
}
