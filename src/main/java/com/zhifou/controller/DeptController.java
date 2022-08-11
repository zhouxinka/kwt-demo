package com.zhifou.controller;

/**
 * @author zhou.peng
 * @desc todo
 * @date 2022 08 11 10:35
 */

import com.zhifou.entity.Department;
import com.zhifou.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/dept")
public class DeptController {
    private DeptServiceImpl deptService;
    @Autowired
    public DeptController(DeptServiceImpl deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        List<Department> list = deptService.list();
        Map<String, Object> data = new HashMap<>();
        data.put("departments",list);
        return data;
    }
}
