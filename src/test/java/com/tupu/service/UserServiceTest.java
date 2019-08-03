package com.tupu.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tupu.domain.User;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void saveUser() {

        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        userService.saveUser(user);
    }
}
