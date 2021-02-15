package com.gym.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineGymApplication {
	
	@Autowired

	public static void main(String[] args)
	{
		SpringApplication.run(OnlineGymApplication.class, args);
	
	}
}
