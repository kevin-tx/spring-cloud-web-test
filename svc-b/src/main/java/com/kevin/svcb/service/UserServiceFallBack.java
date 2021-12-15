package com.kevin.svcb.service;

import com.kevin.svcb.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author TX
 * @date 2021/12/2 15:42
 */

@Slf4j
@Service
public class UserServiceFallBack implements UserService {

    @Override
    public User getUser(Integer id) {
        log.error("callUser fall back: " + id);
        return null;
    }
}
