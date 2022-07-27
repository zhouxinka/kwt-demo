package com.zhifou.listener;

import com.zhifou.event.UserEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 21 12:06
 */
@Component
public class UserListener implements ApplicationListener<UserEvent> {
    @Override
    public void onApplicationEvent(UserEvent event) {
        System.out.println("UserListener监听到UserEvent："+event.getId());
    }
}
