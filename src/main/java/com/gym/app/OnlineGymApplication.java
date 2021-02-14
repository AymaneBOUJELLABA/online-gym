package com.gym.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.gym.app"})
@EnableMongoRepositories(basePackages = "com.gym.app.repositories")
public class OnlineGymApplication {
	
	public static void main(String[] args)
	{
		SpringApplication.run(OnlineGymApplication.class, args);
	}
}
