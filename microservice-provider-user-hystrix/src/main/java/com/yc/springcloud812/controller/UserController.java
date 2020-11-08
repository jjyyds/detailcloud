package com.yc.springcloud812.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yc.springcloud812.security.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get/{name}")
    @HystrixCommand(fallbackMethod = "errorCallBack")
    public  Object get(@PathVariable("name")String name) {
        User users = new User();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }

    //指定一个降级的方法
    public  Object errorCallBack(@PathVariable("name")String name){
        return "查无此人，服务忙";
    }
}
