package com.zhfk.cloud.userservice.service;

import com.zhfk.cloud.common.User;

public interface UserService {

    int create(User user);

    User getUser(Long id);
}
