package com.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhifou.entity.User;
import com.zhifou.mapper.UserMapper;
import com.zhifou.service.UserService;
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

    @Override
    public User login(User user) {
        User userOne = this.getOne(new QueryWrapper<User>().eq("username", user.getUsername())
                .eq("password", user.getPassword()));
        return null == userOne ? null : userOne;
    }
}
