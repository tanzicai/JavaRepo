package com.tanzicai.caimusic.service;

import com.tanzicai.caimusic.dto.UserCreateRequest;
import com.tanzicai.caimusic.dto.UserDto;
import com.tanzicai.caimusic.enums.Gender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;



    @Test
    void getCurrentUser() {

        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("tanzicai");
        userCreateRequest.setPassword("123456");
        userCreateRequest.setNickname("ceshi");
        userCreateRequest.setGender(Gender.MALE);
        UserDto userDto = userService.create(userCreateRequest);
        System.out.println("************************************");
        System.out.println(userDto);
        System.out.println("************************************");

    }
}