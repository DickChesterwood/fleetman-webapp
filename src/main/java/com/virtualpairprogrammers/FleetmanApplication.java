package com.virtualpairprogrammers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
public class FleetmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetmanApplication.class, args);
	}
	
}
