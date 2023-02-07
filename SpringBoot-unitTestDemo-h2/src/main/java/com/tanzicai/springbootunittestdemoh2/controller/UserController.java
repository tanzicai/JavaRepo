package com.tanzicai.springbootunittestdemoh2.controller;


import com.tanzicai.springbootunittestdemoh2.entity.User;
import com.tanzicai.springbootunittestdemoh2.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final IUserService userService;

    public UserController(final IUserService userService) {
        this.userService = userService;
    }

    /**
     * find user list.
     *
     * @return list
     */
    @GetMapping("user/list")
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(userService.findAll());
    }


}
