package com.zhifou.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 21 12:04
 */
public class UserEvent extends ApplicationEvent {
    private Long id;

    public UserEvent(Object source,Long id) {
        super(source);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
