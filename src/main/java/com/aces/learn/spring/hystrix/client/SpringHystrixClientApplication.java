package com.aces.learn.spring.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class SpringHystrixClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHystrixClientApplication.class, args);
	}
}
