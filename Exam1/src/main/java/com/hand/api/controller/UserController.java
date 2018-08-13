package com.hand.api.controller;

import java.util.List;
import javax.annotation.Resource;

import com.hand.api.service.UserService;
import com.hand.infra.dataobject.CustomerDO;
import com.hand.infra.dataobject.UserDO;
import com.hand.infra.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @Resource
    private CustomerMapper customerMapper;


    @PutMapping("/add")
    public Long addUser(@RequestBody UserDO userDO) {
        long id = userService.create(userDO);
        logger.error("add user:{}", userDO);
        return id;
    }

    @PostMapping("/update")
    public UserDO updateUser(@RequestBody UserDO userDO) {
        userService.update(userDO);
        UserDO user = userService.getById(userDO.getId());
        logger.error("update user:{}", user);
        return user;
    }

    @DeleteMapping("/delete")
    public void delUser(@CookieValue("id") Long id) {
        UserDO userDO = userService.getById(id);
        userService.delete(id);
        logger.error("del user:{}", userDO);
    }

    @PostMapping("/login")
    public String login(String name, String password) {
        CustomerDO customerDO = new CustomerDO();
        customerDO.setFirstName(name);
        customerDO.setLastName(password);
        List<CustomerDO> customerDOS = customerMapper.select(customerDO);
        if (customerDOS != null && customerDOS.size() > 0) {
            return "login success";
        }
        logger.error("user login:{}:","username:"+name+"password:"+password);
        return "login fail";
    }

}
