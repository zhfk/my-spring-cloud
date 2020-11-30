package com.zhfk.cloud.hystrixservice.service;

import com.zhfk.cloud.common.CommonResult;

public interface UserService {
    CommonResult getUser(Long id);
}
