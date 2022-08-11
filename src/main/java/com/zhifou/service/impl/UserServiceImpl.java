package com.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhifou.entity.User;
import com.zhifou.event.UserEvent;
import com.zhifou.mapper.UserMapper;
import com.zhifou.service.OrderService;
import com.zhifou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 知否技术
 * @since 2022-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /** 注入ApplicationContext用来发布事件 */
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private OrderService orderService;

    /*@Autowired
    public UserServiceImpl(ApplicationContext applicationContext,OrderService orderService) {
        System.out.println("UserServiceImpl有参构造执行了");
        //查看这个applicationContext具体是哪个实现类,是AnnotationConfigServletWebServerApplicationContext
        System.out.println(applicationContext.getClass().getName());
        System.out.println(orderService.getOrderId());
        this.applicationContext = applicationContext;
        this.orderService = orderService;
    }*/

    @Override
    public User login(User user) {
        User userOne = this.getOne(new QueryWrapper<User>().eq("username", user.getUsername())
                .eq("password", user.getPassword()));
        return null == userOne ? null : userOne;
    }

    public void testUserEvent(Long id){
        System.out.println("开始发布事件");
        //发布事件
        applicationContext.publishEvent(new UserEvent(this,id));
        System.out.println("结束发布事件");
    }

}
