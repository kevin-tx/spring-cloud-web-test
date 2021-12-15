package com.kevin.svca.controller;

import com.kevin.svca.dto.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TX
 * @date 2021/11/29 14:08
 */
@RestController
@Slf4j
public class UserController {

    @PostMapping("/user/get/{userId}")
    @HystrixCommand(fallbackMethod = "hystrixGetUser")
    public User getUser(@PathVariable("userId")Integer id){
        log.info("getUser: " + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(id<5){
            return new User(id, "U_" + id);
        }
        throw new RuntimeException("User is not exist");
    }

    private User hystrixGetUser(Integer id){
        log.info("hystrixGetUser: " + id);
        return new User(-1, "User is not exist");
    }

    @PostMapping("/book/get/{userId}")
    @HystrixCommand(fallbackMethod = "hystrixGetBook")
    public User getBook(@PathVariable("userId")Integer id){
        log.info("getBook: " + id);
        if(id<5){
            return new User(id, "Book_" + id);
        }
        throw new RuntimeException("Book is not exist");
    }

    private User hystrixGetBook(Integer id){
        log.info("hystrixGetBook: " + id);
        return new User(-1, "Book is not exist");
    }

    @RequestMapping("/event/test")
    public void getEvent(@RequestParam("eid") int eid, HttpServletResponse response){
        response.setContentType("text/event-stream");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("expries", -1);
        try {
            PrintWriter out = response.getWriter();
            while (true) {
                out.print("Event triggled, id: " + eid + ", timestamp" + System.currentTimeMillis());
                out.flush();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
