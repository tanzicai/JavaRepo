package org.books.tanzicai.service;

import org.books.tanzicai.entity.User;
import org.books.tanzicai.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanzicai
 */
@Service
public class UserServiceImpl {
    /**
     * user dao impl
     */
    @Autowired
    private UserDaoImpl userDao;

    /**
     * init
     */
    public UserServiceImpl() {
    }

    /**
     * find user list
     * @return user list
     */
    public List<User> findUserList() {
        return this.userDao.findUserList();
    }

    /**
     * set dao
     * @param userDao user dao
     */
    public void  setUserDao(UserDaoImpl userDao){
        this.userDao = userDao;
    }
}
