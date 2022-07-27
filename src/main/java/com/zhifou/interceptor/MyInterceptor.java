package com.zhifou.interceptor;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.zhifou.entity.ResponseEntity;
import com.zhifou.util.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Desc:
 * @Author: 知否技术
 * @date: 下午7:11 2022/4/24
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        System.out.println("进入了拦截器，被拦截的方法是："+methodName);
        String token = request.getHeader("token");
        System.out.println("token:"+token);
        //Map<String, Object> result = new HashMap<>();
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            // 校验token,校验失败会抛出异常
            JwtUtil.verifyToken(token);
            return true;
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            responseEntity =  ResponseEntity.error("token已过期");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = ResponseEntity.error("token无效");
        }
        response.setContentType("application/json;charset=UTF-8");
        //response.getWriter().println(JSONUtil.parse(result));
        response.getWriter().println(JSONUtil.parse(responseEntity));
        return false;
    }

    public static void main(String[] args) {
        ResponseEntity responseEntity = ResponseEntity.error("token无效");
        JSON json = JSONUtil.parse(responseEntity);
        System.out.println(json);
        System.out.println(json.toString());
    }
}
