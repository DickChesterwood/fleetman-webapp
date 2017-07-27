package com.virtualpairprogrammers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Profile("!docker-demo")
@SpringBootApplication
@EnableScheduling
public class FleetmanApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FleetmanApplication.class, args);
		Startup startup = ctx.getBean(Startup.class);
		startup.populateData();
	}
	
}

