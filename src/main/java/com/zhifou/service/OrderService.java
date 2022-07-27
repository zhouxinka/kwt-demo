package com.zhifou.service;

import org.springframework.stereotype.Service;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 22 9:00
 */
@Service
public class OrderService {

    public OrderService(){
        System.out.println("OrderService无参构造方法执行了");

    }
    public String getOrderId(){
        return "OrderId:Order-2022-07-22-347";
    }

}
