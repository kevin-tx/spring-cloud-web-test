package com.kevin.ek;

import com.kevin.ek.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author TX
 * @date 2021/11/25 16:55
 */
@Component
public class Init {

    @Autowired
    private Person person;


    @PostConstruct
    public void init(){
        System.out.println(person);
    }
}
