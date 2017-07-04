package com.virtualpairprogrammers.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Don't run Eureka etc in development
@Configuration
@Profile("!development")
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
public class CloudConfiguration {
	
}
