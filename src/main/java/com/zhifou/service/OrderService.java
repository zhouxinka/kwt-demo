package com.zhifou.service;

import com.zhifou.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 22 9:00
 */
@Service
public class OrderService {
    /**
     * OrderService与UserServiceImpl现在是循环依赖，
     * 如果他们都是默认的无参构造方法，那么spring的三级缓存帮我们解决了循环依赖问题；
     * 如果不使用无参构造，而是用有参构造，那就要在构造方法的参数上加上@Lazy注解
     */


    @Autowired
    private UserServiceImpl userService;

    /*@Autowired
    public OrderService(@Lazy UserServiceImpl userService) {
        this.userService = userService;
    }*/

    public String getOrderId(){
        return "OrderId:Order-2022-07-22-347";
    }

}
