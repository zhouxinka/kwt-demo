package com.zhifou.service;

import com.zhifou.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 知否技术
 * @since 2022-04-23
 */
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);
}
