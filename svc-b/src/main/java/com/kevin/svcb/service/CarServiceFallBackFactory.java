package com.kevin.svcb.service;

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
public class CarServiceFallBackFactory implements FallbackFactory<CarService> {

    @Autowired
    private CarServiceFallBack carServiceFallBack;

    @Override
    public CarService create(Throwable throwable) {
        log.error("CarServiceFallBackFactory: error", throwable);
        return carServiceFallBack;
    }
}
