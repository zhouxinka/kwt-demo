package com.zhifou.interceptor;

import cn.hutool.json.JSONUtil;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.zhifou.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: 知否技术
 * @date: 下午7:11 2022/4/24
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Map<String, Object> result = new HashMap<>();
        try {
            // 校验token,校验失败会抛出异常
            JwtUtil.verifyToken(token);
            return true;
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            result.put("code", "500");
            result.put("msg", "token已过期");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", "500");
            result.put("msg", "token无效");
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(JSONUtil.parse(result));
        return false;
    }
}
