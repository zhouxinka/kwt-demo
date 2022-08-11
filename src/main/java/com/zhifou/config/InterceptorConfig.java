package com.zhifou.config;

import com.zhifou.interceptor.MyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Desc:
 * @Author: 知否技术
 * @date: 下午7:18 2022/4/24
 */
@Component
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                // 拦截所有请求
                .addPathPatterns("/**")
                // 排除路径，比如用户登录、退出等
               .excludePathPatterns("/user/newLogin");
    }
}