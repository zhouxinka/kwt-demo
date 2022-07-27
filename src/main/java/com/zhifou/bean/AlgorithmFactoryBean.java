package com.zhifou.bean;

import com.zhifou.service.AlgorithmService;
import com.zhifou.service.impl.AESalgorithmServiceImpl;
import com.zhifou.service.impl.MD5algorithmServiceImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhou.peng
 * @desc FactoryBean就是一个工厂Bean，
 * 相当于将工厂类放到了Spring中管理、
 * 当获取此Bean的时候返回的是此工厂生成的Bean
 * @date 2022 07 21 14:43
 */
public class AlgorithmFactoryBean implements FactoryBean<AlgorithmService> {
    //算法类型：MD5 | AES
    private String algorithmType;

    @Override
    public AlgorithmService getObject() {
        if("MD5".equals(algorithmType)){
            System.out.println("实例化一个MD5algorithmServiceImpl");
            return new MD5algorithmServiceImpl();
        }
        if("AES".equals(algorithmType)){
            System.out.println("实例化一个AESalgorithmServiceImpl");
            return new AESalgorithmServiceImpl();
        }
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return AlgorithmService.class;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }
}
