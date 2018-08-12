package com.hand.api.controller;

import javax.annotation.Resource;

import com.hand.api.service.UserService;
import com.hand.infra.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Value("${hello}")
    private String hello;

    @Resource
    private UserService userService;


    @RequestMapping("/info/{id}")
    @ResponseBody
    public UserDO getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addUser() {
        UserDO userDO = new UserDO();
        userDO.setUsername("zhangsan");
        userDO.setPassword("12345");
        userService.createUser(userDO);
        return "add user ok";
    }

    @PostMapping("/show")
    @ResponseBody
    public UserDO showUser(@RequestParam("q") String q, @RequestBody UserDO userDO) {
        System.out.println(q);
        return userDO;
    }

    @RequestMapping("/redirect")
    public String testRedirect(){
        System.out.println(hello);
        return "redirect:/user/info/1";
    }


}
