package org.books.tanzicai.Service;


import org.books.tanzicai.Dao.UserDaoImpl;
import org.books.tanzicai.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanzicai
 */
@Service
public class UserServiceImpl {
    /**
     * user dao impl.
     */
    @Autowired
    private UserDaoImpl userDao;

    /**
     * find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return userDao.findUserList();
    }

}
