package com.example.shirojwt2.util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author 张威
 */
public class JwtUtils {

    public final static long VALID_TIME =  1000 * 60;


    /**
     * 构建token信息
     * @param username 用户名 也可以是id 不建议保存其他信息 因为token的唯一职责是身份验证
     * @param security
     * @return
     */
    public static String buildToken(String username,String security){
        try {
//            根据用户的密码生成密钥 这里可以更改
            Algorithm algorithm = Algorithm.HMAC256(security);
            return JWT.create()
                    .withClaim("username",username)
                    .withExpiresAt(new Date(System.currentTimeMillis() + VALID_TIME))
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据token获取解析用户的username
     * @param token 生成的token信息
     * @return
     */
    public static String getUsername(String token){
            try {
                String username = JWT.decode(token).getClaim("username").asString();
                return username;
            }catch (RuntimeException e){
            }
         return null;
    }

    /**
     * 验证token完整性
     * @param username 用户名
     * @param security 用户的认证信息 一般为密码
     * @param token token信息
     * @return
     */
    public static boolean verifyToken(String username,String security,String token) throws TokenExpiredException {

//            获取密钥 根据用户密码加密生成
        try {
            Algorithm algorithm = Algorithm.HMAC256(security);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            verifier.verify(token);
            return true;
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
            return false;
    }

}
