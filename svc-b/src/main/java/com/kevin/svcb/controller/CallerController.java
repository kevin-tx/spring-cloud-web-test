package com.kevin.svcb.controller;

import com.kevin.svcb.dto.User;
import com.kevin.svcb.service.CarService;
import com.kevin.svcb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TX
 * @date 2021/12/2 15:37
 */
@RestController
@Slf4j
public class CallerController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @RequestMapping("/call/user/{userId}")
    public User callUser(@PathVariable("userId") int userId) {
        log.info("CallerController.callUser: " + userId);
        User user = userService.getUser(userId);
        log.info(user == null ? "null" : user.getName());
        return user;
    }


    @RequestMapping("/call/car/{carId}")
    public User callCar(@PathVariable("carId") int userId) {
        log.info("CallerController.callUser: " + userId);
        User user = carService.getCar(userId);
        log.info(user == null ? "null" : user.getName());
        return user;
    }
}
