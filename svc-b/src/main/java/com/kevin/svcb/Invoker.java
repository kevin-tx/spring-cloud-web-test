package com.kevin.svcb;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TX
 * @date 2021/12/1 14:09
 */

@Slf4j
public class Invoker {
    public static void main(String[] args) {
        changeCacheLogerLevel("com.kevin.svcb", Level.INFO);
        changeSingleLogerLevel("org.springframework.web.client.RestTemplate", Level.INFO);
        changeSingleLogerLevel("org.springframework.web.HttpLogging", Level.INFO);

        int i = 0;
        while (i<20){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    call(1);
                }
            }).start();
            i++;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    private static void call(int id){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<String>("");
        log.info("req");
//        String body = restTemplate.exchange("http://10.10.1.73:7801/kev/car/get/"+id, HttpMethod.POST, requestEntity, String.class).getBody();
        String body = restTemplate.exchange("http://10.10.1.73:7802/call/car/"+id, HttpMethod.POST, requestEntity, String.class).getBody();

        log.info("return: " + body);
    }

    private static void changeCacheLogerLevel(String loggerPackage, Level loggerLevel){
        // #1.get logger context
        ch.qos.logback.classic.LoggerContext loggerContext = (ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggerList = loggerContext.getLoggerList();
        // #2.filter the Logger object
        List<Logger> packageLoggerList = loggerList.stream().filter(a -> a.getName().startsWith(loggerPackage)).collect(Collectors.toList());
        // #3.set level to logger
        for (ch.qos.logback.classic.Logger logger : packageLoggerList) {
            logger.setLevel(loggerLevel);
        }
    }

    private static void changeSingleLogerLevel(String loggerName, Level loggerLevel){
        ch.qos.logback.classic.LoggerContext loggerContext = (ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
        Logger logger = loggerContext.getLogger(loggerName);
        logger.setLevel(loggerLevel);
    }

}
