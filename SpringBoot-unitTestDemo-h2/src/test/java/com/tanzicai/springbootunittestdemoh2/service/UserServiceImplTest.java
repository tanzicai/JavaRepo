package com.tanzicai.springbootunittestdemoh2.service;

import com.tanzicai.springbootunittestdemoh2.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserServiceImpl userService;

    @Test
    public void findAll() {
        //Given
        Mockito.when(userService.findAll()).thenReturn(
                Collections.singletonList(new User(1L, "pdai.tech", "1221111")));

        //When
        List<User> userDtoList = userService.findAll();

        //Then
        assertFalse(userDtoList.isEmpty());
        verify(userService, times(1)).findAll();
    }



}
