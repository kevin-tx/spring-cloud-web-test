package com.kevin.svcb.service;

import com.kevin.svcb.dto.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TX
 * @date 2021/12/2 15:42
 */

@Slf4j
@Service
public class UserServiceFallBackFactory implements FallbackFactory<UserService> {

    @Autowired
    private UserServiceFallBack userServiceFallBack;

    @Override
    public UserService create(Throwable throwable) {
        log.error("UserServiceFallBackFactory: error", throwable);
        return userServiceFallBack;
    }
}
