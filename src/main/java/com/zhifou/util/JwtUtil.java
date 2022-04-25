package com.zhifou.util;

import cn.hutool.core.map.MapUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * @Desc:
 * @Author: 知否技术
 * @date: 下午10:31 2022/4/23
 */
public class JwtUtil {
    // 秘钥
    private static final String SECRET = "SECRET_PRIVATE!";
    private static final long TIME_UNIT = 1000;

    public static void main(String[] args) {
        System.out.println(createJwtToken("1",50000));
    }
    // 生成包含用户id的token
    public static String createJwtToken(String userId, long expireTime) {
        Date date = new Date(System.currentTimeMillis() + expireTime * TIME_UNIT);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT.create()
                .withClaim("userId", userId)
                .withExpiresAt(date) // 设置过期时间
                .sign(algorithm);     // 设置签名算法
    }

    // 生成包含自定义信息的token
    public static String createJwtToken(Map<String, String> map, long expireTime) {
        JWTCreator.Builder builder = JWT.create();
        if (MapUtil.isNotEmpty(map)) {
            map.forEach((k, v) -> {
                builder.withClaim(k, v);
            });
        }
        Date date = new Date(System.currentTimeMillis() + expireTime * TIME_UNIT);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return builder
                .withExpiresAt(date) // 设置过期时间
                .sign(algorithm);     // 设置签名算法
    }

    // 校验token，其实就是比较token
    public static DecodedJWT verifyToken(String token) {
        // 如果校验失败，程序会抛出异常
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }

    // 从token中获取用户id
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    // 从token中获取定义的荷载信息
    public static String getTokenClaim(String token, String key) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    // 判断 token 是否过期
    public static boolean isExpire(String token) {
        DecodedJWT jwt = JWT.decode(token);
        // 如果token的过期时间小于当前时间，则表示已过期，为true
        return jwt.getExpiresAt().getTime() < System.currentTimeMillis();
    }
}
