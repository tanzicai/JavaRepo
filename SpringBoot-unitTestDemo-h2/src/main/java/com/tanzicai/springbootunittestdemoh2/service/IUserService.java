package com.tanzicai.springbootunittestdemoh2.service;

import com.tanzicai.springbootunittestdemoh2.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * find all user.
     *
     * @return list
     */
    List<User> findAll();
}
