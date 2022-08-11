package com.zhifou.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhifou.entity.Department;
import com.zhifou.mapper.DeptMapper;
import com.zhifou.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 08 11 10:29
 */
@Service
@DS("db1") //这个注解表示使用哪个数据源，不写的话表示默认使用master数据源,同时这个注解还能用在方法上
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Department> implements DeptService {
}
