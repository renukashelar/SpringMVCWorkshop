package com.cybage.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cybage")
public class SpringMvcWorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcWorkshopApplication.class, args);
	}

}
