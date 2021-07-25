package com.opsec.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.opsec.api")
@EnableDiscoveryClient
@EnableZuulProxy
public class UserCompositeApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCompositeApplication.class, args);
    }

}
