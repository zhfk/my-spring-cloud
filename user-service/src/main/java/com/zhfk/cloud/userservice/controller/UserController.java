package com.zhfk.cloud.userservice.controller;

import com.zhfk.cloud.common.CommonResult;
import com.zhfk.cloud.common.User;
import com.zhfk.cloud.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody User user) {
        int id = userService.create(user);
        return new CommonResult<>("操作成功", id);
    }

    @GetMapping("/{id}")
    public CommonResult<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        log.info("根据id获取用户信息，用户名称为：{}", user.getName());
        return new CommonResult<>(user);
    }

}
