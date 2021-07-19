package com.opsec.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserCoreMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCoreMicroServiceApplication.class, args);
	}

}
