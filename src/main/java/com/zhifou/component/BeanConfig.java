package com.zhifou.component;

import com.zhifou.bean.AlgorithmFactoryBean;
import com.zhifou.service.DemoService4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 提供bean的类
 * @author zhou.peng
 * @desc todo
 * @date 2022 07 22 11:45
 */
@Configuration
public class BeanConfig {
    /**
     * FactoryBean就是一个工厂Bean，
     * 相当于将工厂类放到了Spring中管理、
     * 当获取此Bean的时候返回的是此工厂生成的Bean
     * @return
     */
    @Bean
    public AlgorithmFactoryBean algorithmFactoryBean(){
        System.out.println("实例化一个AlgorithmFactoryBean bean");
        AlgorithmFactoryBean algorithmFactoryBean = new AlgorithmFactoryBean();
        algorithmFactoryBean.setAlgorithmType("MD5");
        return algorithmFactoryBean;
    }
    @Bean(initMethod = "initMethod")
    public DemoService4 demoService4(){
        return new DemoService4();
    }
}
