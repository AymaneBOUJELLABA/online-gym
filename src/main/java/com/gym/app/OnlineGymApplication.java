package com.gym.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootApplication
public class OnlineGymApplication {
	
	@Autowired
	@LocalServerPort
	private static int port;

	public static void main(String[] args)
	{
		SpringApplication.run(OnlineGymApplication.class, args);
		System.out.println("app starting in : " +port);
	}
}
