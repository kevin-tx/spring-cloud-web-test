package com.kevin.svcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author TX
 * @date 2020/5/28 14:47
 */

@SpringBootApplication
//因为spring-cloud 里面有多个注册中心,所以这里使用EnableDiscoveryClient注解,而不是EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
