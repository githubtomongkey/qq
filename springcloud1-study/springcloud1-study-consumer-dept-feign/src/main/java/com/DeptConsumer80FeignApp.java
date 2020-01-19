package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="com.atguigu.springcloud")//这个地方有问题.有点不明白,不加括号的东西貌似不成立
public class DeptConsumer80FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80FeignApp.class,args);
    }
}