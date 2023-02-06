package com.tanzicai.springboothelloworld.service;

import com.tanzicai.springboothelloworld.dao.UserRepository;
import com.tanzicai.springboothelloworld.entity.User;

import java.util.List;

/**
 * @author tanzicai
 */
public interface UserService {
    void add(User user);
    List findAll();

}
