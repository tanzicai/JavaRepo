package com.tanzicai.caimusic.repository;

import com.tanzicai.caimusic.entity.User;
import com.tanzicai.caimusic.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository ;

    @Test
    public void findByUsername(){
        User user = new User();
        user.setUsername("tanzicai");
        user.setNickname("cai");
        user.setEnabled(true);
        user.setLocked(false);
        user.setPassword("234567");
        user.setGender(Gender.MALE);
        user.setLastLoginIp("172.0.0.1");
        user.setLastLoginTime(new Date());
        User save = userRepository.save(user);
        System.out.println(save);
    }

}