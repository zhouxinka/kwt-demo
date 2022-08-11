package com.zhifou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;

@SpringBootApplication
@MapperScan("com.zhifou.mapper")//扫描DAO接口
public class JwtDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(JwtDemoApplication.class, args);
        String userListener = applicationContext.getBeanFactory().getBeanDefinition("userListener").getBeanClassName();
        System.out.println("userListener:"+userListener);
        Iterator<String> beanNamesIterator = applicationContext.getBeanFactory().getBeanNamesIterator();
        while(beanNamesIterator.hasNext()){
            System.out.println("容器中所有的bean的名字是:"+beanNamesIterator.next());
        }
    }

}
