package com.zhfk.cloud.hystrixservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhfk.cloud.common.CommonResult;
import com.zhfk.cloud.common.User;
import com.zhfk.cloud.hystrixservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @Override
    public CommonResult getUser(Long id) {
        log.info("hystrix UserService => getUser");
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    public CommonResult getDefaultUser(@PathVariable Long id) {
        log.info("hystrix UserService => getDefaultUser");
        User defaultUser = new User("defaultUser");
        return new CommonResult(defaultUser);
    }
}
