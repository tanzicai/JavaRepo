package org.books.tanzicai.Dao;

import org.books.tanzicai.Entity.User;

import java.util.Collections;
import java.util.List;

/**
 * @author tanzicai
 */
public class UserDaoImpl {
    /**
     * mocked to find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("tanzicai", 22));
    }

}
