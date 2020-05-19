package com.virtualpairprogrammers;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Don't run Eureka etc in development
@Configuration
@Profile({"production","docker"})
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
public class CloudConfiguration {
	
}
