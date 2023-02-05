package com.tanzicai.springboothelloworld.controller;

import com.tanzicai.springboothelloworld.entity.User;
import com.tanzicai.springboothelloworld.service.Impl.UserServiceImpl;
import com.tanzicai.springboothelloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tanzicai
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("add")
    public User add(User user){
        userService.add(user);
        return user;
    }
    @RequestMapping("list")
    public List<User> list() {
        return userService.findAll();
    }
}

