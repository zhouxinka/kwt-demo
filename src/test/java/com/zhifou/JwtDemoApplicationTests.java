package com.zhifou;

import com.zhifou.service.AlgorithmService;
import com.zhifou.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtDemoApplicationTests {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AlgorithmService algorithmService;
    @Test
    void testFactoryBean(){
        algorithmService.encrypt();
    }
    /**
     * 测试UserEvent
     */
    @Test
    void testUserEvent() {
        userService.testUserEvent(1001L);
    }

}
