package com.zhifou.controller;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zhifou.entity.User;
import com.zhifou.exception.APIException;
import com.zhifou.service.UserService;
import com.zhifou.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 知否技术
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
                    throws IOException, JsonProcessingException {
                arg1.writeString("");
            }
        });
    }

    //@Autowired
    private UserService userService;

    /**
     * 如果仅有一个构造器那么@Autowired是可以省略的
     * @param userService
     */
    @Autowired
    public UserController(UserService userService) {
        System.out.println("UserController的有参构造方法执行了");
        System.out.println( userService.hashCode());
        this.userService = userService;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        System.out.println("##################login####################");
        Map<String, Object> data = new HashMap<>();
        User userOne = userService.login(user);
        if (null != userOne) {
            data.put("code", 200);
            data.put("msg", "登陆成功");
            data.put("token", JwtUtil.createJwtToken(userOne.getId().toString(), 24 * 10));
        } else {
            data.put("code", 400);
            data.put("msg", "账号或者密码错误");
        }
        return data;
    }

    @PostMapping("/newLogin")
    public Map<String, Object> newLogin(@RequestBody @Validated User user) {
        System.out.println("##################newLogin####################");
        User userOne = userService.login(user);
        Map<String, Object> data = new HashMap<>();
        if(userOne != null){
            String token = JwtUtil.createJwtToken(userOne.getId().toString(), 1*60);
            data.put("token",token);
            return data;
        }else{
            throw new APIException("用户不存在");
        }
    }

    @GetMapping("/list")
    public List<User> list() {
        /*List<User> list = userService.list();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new APIException(e.getMessage());
        }
        return result;*/
        List<User> list = userService.list();
        return list;
    }

    @GetMapping("/getUserById")
    public User getUserById() {
        userService.getById("2");
        return null;
    }

}
