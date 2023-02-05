package org.books.tanzicai.dao;

import org.books.tanzicai.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * @author tanzicai
 */
@Repository
public class UserDaoImpl  {
    /**
     * init
     */
    public UserDaoImpl () {
    }

    /**
     * mocked to find user list
     * @return user list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("pdai", 18));
    }

}
