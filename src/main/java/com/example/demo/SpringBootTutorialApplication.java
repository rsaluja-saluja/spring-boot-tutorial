package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@EnableScheduling
public class SpringBootTutorialApplication {

	@Value("${spring.application.name}")
	private String appName;
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootTutorialApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootTutorialApplication.class, args);
		
		logger.info("Info message");
		logger.error("Error Message");
		logger.warn("Warn message");
		logger.debug("Debug message");
	//	System.out.println("Application Name: "+ appName);
	}

	@RequestMapping("/")
	public String getName() {
		return appName;
	}
	
	@Bean
	public RestTemplate	getRestTemplate() {
		return new RestTemplate();
	}
}
