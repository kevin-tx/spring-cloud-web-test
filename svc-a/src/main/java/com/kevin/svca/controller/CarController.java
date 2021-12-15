package com.kevin.svca.controller;

import com.kevin.svca.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author TX
 * @date 2021/11/29 14:08
 */
@RestController
@Slf4j
public class CarController {

    @PostMapping("/car/get/{carId}")
    @HystrixCommand(fallbackMethod = "hystrixGetCar")
    public User getCar(@PathVariable("carId")Integer id){
        log.info("getCar: " + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(id<5){
            return new User(id, "Car_" + id);
        }
        throw new RuntimeException("Car is not exist");
    }

    private User hystrixGetCar(Integer id){
        log.info("hystrixGetCar: " + id);
        return new User(-1, "Car is not exist");
    }
}
