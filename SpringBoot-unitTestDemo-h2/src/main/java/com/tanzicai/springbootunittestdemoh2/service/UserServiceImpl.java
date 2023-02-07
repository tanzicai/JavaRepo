package com.tanzicai.springbootunittestdemoh2.service;

import com.tanzicai.springbootunittestdemoh2.dao.UserRepository;
import com.tanzicai.springbootunittestdemoh2.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;

    /**
     * init.
     *
     * @param userRepository2 user dao
     */
    public UserServiceImpl(final UserRepository userRepository2) {
        this.userRepository = userRepository2;
    }


    /**
     * find all user.
     *
     * @return list
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
