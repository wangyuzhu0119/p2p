package com.bw.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bw.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

@Slf4j
public class JWTUtil {

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";
    /**
     * 加密生成token
     * @param object 载体信息
     * @param maxAge 有效时长
     * @param secret 服务器私钥
     * @param
     * @return
     */
    public static String createToken(User object, long maxAge, String secret) {
        try {
            final Algorithm signer = Algorithm.HMAC256(secret);//生成签名
            String token = JWT.create()
                    .withIssuer("签发者")
                    .withSubject("用户")//主题，科目
                    .withClaim("username", object.getUserUsername())
                    .withClaim("id", object.getId())
                    .withClaim("password",object.getUserPassword())
                    .withExpiresAt(new Date(System.currentTimeMillis() + maxAge))
                    .sign(signer);
            System.out.println(token);
            return Base64.getEncoder().encodeToString(token.getBytes("utf-8"));
        } catch (Exception e) {
            log.error("生成token异常：", e);
            return null;
        }
    }

    /**
     * 解析验证token
     *
     * @param token  加密后的token字符串
     * @param secret 服务器私钥
     * @return
     */
    public static Boolean verifyToken(String token, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(new String(Base64.getDecoder().decode(token),"utf-8"));
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(e);
            return false;
        }
    }

}
