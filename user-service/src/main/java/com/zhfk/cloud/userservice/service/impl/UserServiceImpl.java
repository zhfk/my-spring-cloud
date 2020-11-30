package com.zhfk.cloud.userservice.service.impl;

import com.zhfk.cloud.common.User;
import com.zhfk.cloud.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public int create(User user) {
        log.info("create user => " + user.getName());
        return 1;
    }

    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setName("Mike");
        return user;
    }
}
