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
public class CarServiceFallBack implements CarService {

    @Override
    public User getCar(Integer id) {
        log.error("callCar fall back: " + id);
        return null;
    }
}
