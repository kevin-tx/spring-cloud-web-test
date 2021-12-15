package com.kevin.svcb.service;

import com.kevin.svcb.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author TX
 * @date 2021/12/2 15:39
 */

@FeignClient(name = "server-a", contextId = "svc-b-a-car", fallbackFactory = CarServiceFallBackFactory.class)
public interface CarService {

//    @RequestMapping(path = "/user/get/{userId}", method = RequestMethod.POST)
//    User callUser(@PathVariable("userId") int id);

    @PostMapping("/car/get/{carId}")
    User getCar(@PathVariable("carId")Integer id);
}
