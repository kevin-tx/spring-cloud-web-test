package com.kevin.svcb.service;

import com.kevin.svcb.dto.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author TX
 * @date 2021/12/2 15:39
 */

@FeignClient(name = "server-a", contextId = "svc-b-a", fallbackFactory = UserServiceFallBackFactory.class)
public interface UserService {

//    @RequestMapping(path = "/user/get/{userId}", method = RequestMethod.POST)
//    User callUser(@PathVariable("userId") int id);


    @PostMapping("/kev/user/get/{userId}")
    User getUser(@PathVariable("userId")Integer id);
}
