package com.tanzicai.springboothelloworld.dao;

import com.tanzicai.springboothelloworld.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    /**
     * user's mocked List
     */
    private ArrayList<User> userDemoList = new ArrayList<>();

    /**
     * user's mocked List
     */


    /**
     * save user to list
     * @param user user
     */

    public  void save(User user){
        userDemoList.add(user);
    }

    /**
     * get user list
     * @return userDemoList
     */
    public List<User> findAll() {
        return userDemoList;
    }




}
