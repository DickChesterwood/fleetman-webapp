package com.virtualpairprogrammers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class FleetmanApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FleetmanApplication.class, args);
		Startup startup = ctx.getBean(Startup.class);
		startup.populateData();
	}
	
}

