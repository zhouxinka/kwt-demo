package com.zhifou.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 22 11:40
 */
public class DemoService4 implements InitializingBean {
    @Autowired
    private Environment environment;

    public DemoService4(){
        //容器加载到这个无参构造时候environment属性值还没注入，因为：
        //Spring中对于类的初始化以及注入属性值，这个是两个步骤，不是一次性完成的。
        //此时当类的构造方法执行时，类的属性是并未被注入的，那么也就无法获取到Environment的值了。
        //如果想解决这个问题只能在初始化方法中对这个属性进行操作或者使用构造函数注入
        //如：@PostConstruct注解的方法，initMethod(),afterPropertiesSet()等
        System.out.println("DemoService4的构造方法打印environment="+environment);
    }

    /**
     * 使用JSR-250规范定义的@Postconstruct注解
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("DemoService4使用@postConstruct打印environment="+environment);
    }

    /**
     * 使用@Bean的init-method属性
     */
    public void initMethod() {
        System.out.println("DemoService4使用initMethod打印environment="+environment);
    }


    /**
     * InitializingBean接口中的方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DemoService4使用InitializingBean打印environment=" + environment);
    }

}

