package com.tanzicai.springboothelloworld.service.Impl;

import com.tanzicai.springboothelloworld.dao.UserRepository;
import com.tanzicai.springboothelloworld.entity.User;
import com.tanzicai.springboothelloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanzicai
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userDao;

    @Override
    public void add(User user) {
        System.out.println(user.toString());
        if (user == null){
            System.out.println("user is null");
        }
        else userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
